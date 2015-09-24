/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography.hill;

import Jama.Matrix;
import cryptography.Algorithm;

/**
 *
 * @author eduarc
 */
public class Hill implements Algorithm {

    Matrix[] clearData;
    Matrix[] cipherData;
    HillKey key;
    
    @Override
    public String getName() {
        return "Hill Cipher";
    }

    @Override
    public void cipher() {
        
        if (key == null) {
            throw new IllegalArgumentException("Set a Key at first");
        }
        if (clearData == null) {
            throw new IllegalArgumentException("No target clear data");
        }
        cipherData = new Matrix[clearData.length];
        for (int i = 0; i < clearData.length; i++) {
            cipherData[i] = clearData[i].times(key.nextKey());
            key.mod(cipherData[i]);
        }
    }

    @Override
    public void decipher() {
        
        if (key == null) {
            throw new IllegalArgumentException("Set a Key at first");
        }
        if (clearData == null) {
            throw new IllegalArgumentException("No target cipher data");
        }
        clearData = new Matrix[cipherData.length];
        for (int i = 0; i < clearData.length; i++) {
            clearData[i] = cipherData[i].times(key.nextInverseKey());
            key.mod(clearData[i]);
        }
    }

    @Override
    public void setKeys(Object keys) {
        
        if (keys instanceof HillKey) {
            key = (HillKey)keys;
        } else {
            throw new IllegalArgumentException("Invalid Key type");
        }
    }

    @Override
    public Object getKeys() {
        
        return key;
    }

    @Override
    public void setClearData(Object data) {
        
        clearData = (Matrix[])data;
    }

    @Override
    public Object getClearData() {
        return clearData;
    }

    @Override
    public void setCipherData(Object data) {
        cipherData = (Matrix[])data;
    }

    @Override
    public Object getCipherData() {
        
        return cipherData;
    }
}
