/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography.hill;

import Jama.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * Para usar el Hill básico, dejen el parametro iv como <code>null</code>
 * 
 * @author eduarc
 */
public class HillKey {
    
        // modulo utilizado 26, 256, etc...
    int n;
        // dimension del bloque
    int m;
        // vector inicial
    Matrix iv;
        // llave
    Matrix key;
        // ultima llave obtenida
    Matrix lastKey;
        // ultima llave inversa obtenida
    Matrix lastInverseKey;
    
    public HillKey(int n, int m, int[][] iv, int[][] key) {
        
        this.n = n;
        this.m = m;
        if (m != key.length || m != key[0].length) {
            throw new IllegalArgumentException("Invalid IV or K dimensions");
        }
        double[][] div;
        double[][] dkey;
        
        if (iv != null) {
            div = new double[m][1];
            for (int i = 0; i < m; i++) {
                div[i][0] = iv[i][0];
            }
            this.iv = new Matrix(div);
        }
        
        dkey = new double[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dkey[i][j] = key[i][j];
            }
        }
        this.key = mod(new Matrix(dkey));
        lastKey = this.key;
        lastInverseKey = this.key;
    }
    
    public void restartKey() {
        lastKey = key;
    }
    
    public void restartInverseKey() {
        lastInverseKey = key;
    }
    
    public Matrix nextKey() {
        
        if (iv == null) {
            return key;
        }
        for (int i = 0; i < m; i++) {
            Matrix row = mod(lastKey.times(iv));
            for (int j = 0; j < m; j++) {
                lastKey.set(i, j, row.get(j, 0));
            }
        }
        return mod(lastKey);
    }

    public Matrix nextInverseKey() {
        
        if (iv == null) {
            Matrix mat = key.copy();
            double det = mat.det();
            Matrix inv = mat.inverse();
            inv = inv.times(det);

            BigInteger big = BigInteger.valueOf((long)det);
            double idet = big.modInverse(BigInteger.valueOf(n)).doubleValue();
            inv = inv.times(idet);
            return mod(inv);
        }
        for (int i = 0; i < m; i++) {
            Matrix row = mod(lastInverseKey.times(iv));
            for (int j = 0; j < m; j++) {
                lastInverseKey.set(i, j, row.get(j, 0));
            }
        }
        //double det = lastInverseKey.det();
        //Matrix inv = lastInverseKey.inverse();
        //inv = inv.times(det);
        
        //BigInteger big = BigInteger.valueOf((long)det);
        //double idet = big.modInverse(BigInteger.valueOf(n)).doubleValue();
        //inv = inv.times(idet);
        return mod(lastInverseKey.inverse());
    }
    
    public Matrix[] getImageData(String file) {
        return getData(getImageRawData(file));
    }
    
    public Matrix[] getTextData(String text) {
        return getData(getTextRawData(text));
    }
    
    private Matrix[] getData(ArrayList<Double> rawData) {
        
        int len = rawData.size();
        int r = len%m;
        int dummy = m-(r == 0 ? m : r);
        
        for (int i = 0; i < dummy; i++) {
            rawData.add(0.);
        }
        int blocks = rawData.size()/m;
        
        Matrix[] mat = new Matrix[blocks];
            // OK!
        assert(mat.length%m == 0);
        
        for (int i = 0; i < blocks; i++) {
            double[][] b = new double[1][m];
            for (int j = 0; j < m; j++) {
                b[0][j] = rawData.get(i*m+j);
            }
            mat[i] = new Matrix(b);
        }
        return mat;
    }
    
    private ArrayList<Double> getTextRawData(String text) {
        
        ArrayList<Double> data = new ArrayList();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                data.add((double)(c-'a'));
            }
        }
        return data;
    }
    
    private ArrayList<Double> getImageRawData(String imgPath) {
        
        File f = new File(imgPath);
        if (!f.exists()) {
            throw new IllegalArgumentException("File doesn't exists: "+imgPath);
        }
        BufferedImage buff;
        try {
            buff = ImageIO.read(f);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        ArrayList<Double> data = new ArrayList();
        for (int i = 0; i < buff.getHeight(); i++) {
            for (int j = 0; j < buff.getWidth(); j++) {
                data.add((double)buff.getRGB(i, j));
            }
        }
        return data;
    }
    
    protected Matrix mod(Matrix mat) {
        
        for (int i = 0; i < mat.getRowDimension(); i++) {
            for (int j = 0; j < mat.getColumnDimension(); j++) {
                int v = (int)mat.get(i, j);
                while (v < 0) v += n;
                mat.set(i, j, v%n);
            }
        }
        return mat;
    }
}
