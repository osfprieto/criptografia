/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author Tato
 */
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
           
    public String shiftEncryptor()
    {
        int[] resultInt = new int[100];
        String result = "";
        String aux = "";
      for(int i = 0; i < getPlainText().length(); i++)
      {
          if(getPlainText().charAt(i) != ' '){
            //  System.out.println("Tamaño texto = " + getPlainText().length() + "letra " + i + " = " + getPlainText().charAt(i));
              resultInt[i] = (letterToInt( getPlainText().charAt(i)) + Integer.parseInt(key)) % 26;
             // System.out.println("nueva letra = " + String.valueOf((char)(resultInt[i] + 97)));
              aux = String.valueOf((char)(resultInt[i] + 97));
              result = result + aux; 
          }
          else
          {
              result += " ";
          } 
      }
      
      return result;
    }
    
    public String shiftDecryptor()
    {
        int[] resultInt = new int[100];
        String result = "";
        String aux = "";
        
        for(int j = 0; j<26; j++ ){
            result += (j+1) + ". ";
            for(int i = 0; i < getCipherText().length(); i++)
                {
                 //  System.out.println("Tamaño texto = " + getPlainText().length() + "letra " + i + " = " + getPlainText().charAt(i));
                   if(getCipherText().charAt(i) != ' '){
                        resultInt[i] = (letterToInt( getCipherText().charAt(i)) + j) % 26;
                       // System.out.println("nueva letra = " + String.valueOf((char)(resultInt[i] + 97)));
                         aux = String.valueOf((char)(resultInt[i] + 97));
                         result = result + aux; 
                   }
                   else
                   {
                       result = result + " ";
                   }
                }
            
            result =  result + "\n";     
        }
      return result;
    }
    
    public int letterToInt(char letter)
    {
        
        String aux = String.valueOf((int)letter);
        return Integer.parseInt(aux) - 97;
    }
    

    @Override
    public String getName() {
        return "Criptosistema de Sustitución";
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
        int[] resultInt = new int[100];
        String result = "";
        String aux = "";
      for(int i = 0; i < getPlainText().length(); i++)
      {
          if(getPlainText().charAt(i) != ' '){
            //  System.out.println("Tamaño texto = " + getPlainText().length() + "letra " + i + " = " + getPlainText().charAt(i));
              resultInt[i] = (letterToInt( getPlainText().charAt(i)) + Integer.parseInt(key)) % 26;
             // System.out.println("nueva letra = " + String.valueOf((char)(resultInt[i] + 97)));
              aux = String.valueOf((char)(resultInt[i] + 97));
              result = result + aux; 
          }
          else
          {
              result += " ";
          } 
      }
        setCipherData(result);
    }

    @Override
    public void decipher() {
         int[] resultInt = new int[100];
        String result = "";
        String aux = "";
        
        for(int j = 0; j<26; j++ ){
            result += (j+1) + ". ";
            for(int i = 0; i < getCipherText().length(); i++)
                {
                 //  System.out.println("Tamaño texto = " + getPlainText().length() + "letra " + i + " = " + getPlainText().charAt(i));
                   if(getCipherText().charAt(i) != ' '){
                        resultInt[i] = (letterToInt( getCipherText().charAt(i)) + j) % 26;
                       // System.out.println("nueva letra = " + String.valueOf((char)(resultInt[i] + 97)));
                         aux = String.valueOf((char)(resultInt[i] + 97));
                         result = result + aux; 
                   }
                   else
                   {
                       result = result + " ";
                   }
                }
            
            result =  result + "\n";     
        }
        setClearData(result);
    }
    
}
