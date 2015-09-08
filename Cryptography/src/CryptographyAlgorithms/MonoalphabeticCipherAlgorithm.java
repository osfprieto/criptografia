/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CryptographyAlgorithms;

/**
 *
 * @author Miguel
 */

public class MonoalphabeticCipherAlgorithm {
    
    private String plainText;
    private String cipherText;
    private String key;
    
    public MonoalphabeticCipherAlgorithm(){}
    
    public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };
    
    public char ch[];
 
    public String doEncryption(String s)    {
        char c[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < 26; j++){
                if (p[j] == s.charAt(i)){
                    c[i] = ch[j];
                    break;
                }
            }
        }
        return (new String(c));
    }
 
    public String doDecryption(String s){
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < 26; j++){
                if (ch[j] == s.charAt(i)){
                    p1[i] = p[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }
    public void encrypt(){
        setCipherText(doEncryption(getPlainText().toLowerCase()));
    }
    
    public void decryp(){
        setPlainText(doDecryption(getCipherText().toLowerCase()));
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public void convert(String key) {
        this.ch = key.toCharArray();
    }
}