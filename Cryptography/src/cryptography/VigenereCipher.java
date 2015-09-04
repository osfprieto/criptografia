/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
/**
 *
 * La clave ccorresponde a una cadena perteneciente al alfabeto inglés
 */
public class VigenereCipher implements Algorithm{
    
     private String plainText;
    private String key;
    private String cipherText;
    
    public VigenereCipher()
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
        return "Criptosistema Vigenere";
    }

    @Override
    public void cipher() {
         List<Integer> resultInt = new ArrayList<Integer>();
        String result = "";
        String aux = "";
        int m = getKey().length();
        int indexKey = 0;
        int[] keyIntegers = keyToIntegers(getKey());
        
      for(int i = 0; i < getPlainText().length(); i++)
      {
          if(getPlainText().charAt(i) != ' '){

            resultInt.add((Util.charToNumber( getPlainText().charAt(i)) + keyIntegers[indexKey]) % 26);
            aux = String.valueOf((char)(resultInt.get(i) + 97));
            result = result + aux; 
            indexKey = (indexKey + 1) % m ;
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
        int m = getKey().length();
        int indexKey = 0;
        int[] keyIntegers = keyToIntegers(getKey());
        int ascii = 97;
      for(int i = 0; i < getCipherText().length(); i++)
      {
          if(getCipherText().charAt(i) != ' '){

            resultInt.add(( Util.charToNumber( getCipherText().charAt(i)) - keyIntegers[indexKey]) % 26);
            if( 97 + resultInt.get(i) < 97)
            {
               aux = String.valueOf( (char)(123 + resultInt.get(i))); 
            }
            else
            {
                aux = String.valueOf( (char)(97 + resultInt.get(i)));
            }
            result = result + aux; 
            indexKey = (indexKey + 1) % m ;
          }
          else
          {
                resultInt.add(255);
          }
      }
       setClearData(result);  
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
    
    //Convertir la clave los correspondientes enteros
    private int[] keyToIntegers(String key)
    {
        int [] keyIntegers = new int[key.length()];
        
        for(int i = 0; i < keyIntegers.length; i++)
        {
            keyIntegers[i] = Util.charToNumber(key.charAt(i));
        }
        return keyIntegers;
    }
    
}
