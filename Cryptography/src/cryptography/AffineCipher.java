/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author Miguel
 */
public class AffineCipher {
    
    private String plainText;
    private String cipherText;
    private int a;
    private int b;
    
    public AffineCipher(){}
    
    public String encryptionMessage(String Msg){
        String CTxt = "";
        setA(3);
        setB(6);
        for (int i = 0; i < Msg.length(); i++){
            CTxt = CTxt + (char) ((((a * Msg.charAt(i)) + b) % 26) + 65);
        }
        return CTxt;
    }
 
    public String decryptionMessage(String CTxt){
        String Msg = "";
        setA(3);
        setB(6);
        int a_inv = 0;
        int flag;
        for (int i = 0; i < 26; i++){
            flag = (a * i) % 26;
            if (flag == 1){
                a_inv = i;
                System.out.println(i);
            }
        }
        for (int i = 0; i < CTxt.length(); i++){
            Msg = Msg + (char) (((a_inv * ((CTxt.charAt(i) - b)) % 26)) + 65);
        }
        return Msg;
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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    } 
}
