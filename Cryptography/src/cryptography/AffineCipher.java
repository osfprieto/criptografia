/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.math.BigInteger;

/**
 *
 * @author Miguel
 */
public class AffineCipher {
    
    private String plainText;
    private String cipherText;
    private int firstKey = 5;
    private int secondKey = 19;
    private int module = 26;
    
    public AffineCipher(){}
    
    public String encryptionMessage(String input) {
    StringBuilder builder = new StringBuilder();
    for (int in = 0; in < input.length(); in++) {
        char character = input.charAt(in);
        if (Character.isLetter(character)) {
            character = (char) ((firstKey * (character - 'a') + secondKey) % module + 'a');
        }
        builder.append(character);
    }
    return builder.toString();
}

    public String decryptionMessage(String input) {
    StringBuilder builder = new StringBuilder();
    // compute firstKey^-1 aka "modular inverse"
    BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(module));
    // perform actual decryption
    for (int in = 0; in < input.length(); in++) {
        char character = input.charAt(in);
        if (Character.isLetter(character)) {
            int decoded = inverse.intValue() * (character - 'a' - secondKey + module);
            character = (char) (decoded % module + 'a');
        }
        builder.append(character);
    }
    return builder.toString();
}
    
    public void encryp(){
        setCipherText(encryptionMessage(getPlainText()));
    }
    
    public void decryp(){
        setPlainText(decryptionMessage(getCipherText()));
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public int getFirstKey() {
        return firstKey;
    }

    public void setFirstKey(int firstKey) {
        this.firstKey = firstKey;
    }

    public int getSecondKey() {
        return secondKey;
    }

    public void setSecondKey(int secondKey) {
        this.secondKey = secondKey;
    } 
}
