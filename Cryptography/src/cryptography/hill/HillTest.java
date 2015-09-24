/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography.hill;

import Jama.Matrix;

/**
 *
 * @author eduarc
 */
public class HillTest {
    
    public static void main(String args[]) {
        
        int n = 26;
        int m = 3;
        int[][] key = {{11, 6, 8}, {0, 3, 14}, {24, 0, 9}};
        int[][] iv = null; // {1, 2, 2};
        
        String text = "go navy beat army";
        
        HillKey hKey = new HillKey(n, m, iv, key);
        Hill cipher = new Hill();
        cipher.setKeys(hKey);
        cipher.setClearData(hKey.getTextData(text));
        cipher.cipher();
        
            // Encrypt
        String secret = "";
        Matrix[] secretData = (Matrix[])cipher.getCipherData();
        for (int i = 0; i < secretData.length; i++) {
            for (int j = 0; j < hKey.m; j++) {
                int v = (int)secretData[i].get(0, j);
                secret += (char)(v+'a');
            }
        }
        System.out.println(secret);
        
            // Decrypt
        cipher.setCipherData(hKey.getTextData(secret));
        cipher.decipher();
        secretData = (Matrix[])cipher.getClearData();
        secret = "";
        for (int i = 0; i < secretData.length; i++) {
            for (int j = 0; j < hKey.m; j++) {
                int v = (int)secretData[i].get(0, j);
                secret += (char)(v+'a');
            }
        }
        System.out.println(secret);
    }
}
