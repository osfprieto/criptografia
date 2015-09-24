/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.util.ArrayList;
import java.util.List;


// For this you should send the String representation of integer number
// that you want to use as a key. 
public class ShiftCipher implements Algorithm {
    
    private String plainText;
    private String key;
    private String cipherText;
    
    public ShiftCipher()
    {
    }

    /**
     * @return the plainText
     */
    public String getPlainText() {
        return plainText;
    }

    /**
     * @param plainText the plainText to set
     */
    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the cipherText
     */
    public String getCipherText() {
        return cipherText;
    }

    /**
     * @param cipherText the cipherText to set
     */
    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }
           
    @Override
    public String getName() {
        return "Criptosistema de Desplazamiento";
    }

   

    @Override
    public void setKeys(Object keys) {
        this.key = (String)keys;
    }

    @Override
    public Object getKeys() {
        return this.key;
    }

    @Override
    public void setClearData(Object data) {
        this.plainText = (String)data;
    }

    @Override
    public Object getClearData() {
        return this.plainText;
    }

    @Override
    public void setCipherData(Object data) {
        this.cipherText = (String)data;
    }

    @Override
    public Object getCipherData() {
       return this.cipherText;
    }

    @Override
    public void cipher() {
        List<Integer> resultInt = new ArrayList<Integer>();
        String result = "";
        String aux = "";
      for(int i = 0; i < getPlainText().length(); i++)
      {
          if(getPlainText().charAt(i) != ' '){
            //  System.out.println("Tamaño texto = " + getPlainText().length() + "letra " + i + " = " + getPlainText().charAt(i));
              resultInt.add((Util.charToNumber( getPlainText().charAt(i)) + Integer.parseInt(key)) % 26);
             // System.out.println("nueva letra = " + String.valueOf((char)(resultInt[i] + 97)));
               aux = String.valueOf((char)(resultInt.get(i) + 97));
              result = result + aux; 
          }
          else
          {
              resultInt.add(255);
             
          } 
      }
        setCipherData(result);
    }

    @Override
    public void decipher() {
         List<Integer> resultInt = new ArrayList<Integer>();
        String result = "";
        String aux = "";
        
        for(int j = 0; j<26; j++ ){
            result += (j+1) + ". ";
            for(int i = 0; i < getCipherText().length(); i++)
                {
                 //  System.out.println("Tamaño texto = " + getPlainText().length() + "letra " + i + " = " + getPlainText().charAt(i));
                   if(getCipherText().charAt(i) != ' '){
                        resultInt.add((Util.charToNumber( getCipherText().charAt(i)) + j) % 26);
                       // System.out.println("nueva letra = " + String.valueOf((char)(resultInt[i] + 97)));
                         aux = String.valueOf((char)(resultInt.get(i) + 97));
                         result = result + aux; 
                   }
                   else
                   {
                       resultInt.add(255);
                       
                   }
                }
            
            result =  result + "\n"; 
            resultInt.clear();
        }
        setClearData(result);
    }
    
}
