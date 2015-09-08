/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CryptographyAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Miguel
 */

/**
 *
 * La clave ccorresponde a una cadena perteneciente al alfabeto inglés
 */
public class VigenereCipherAlgorithm implements ControlInterface{
    
     private String plainText;
    private String key;
    private String cipherText;
    private String infoM;
    private String infoKey;
    
    public VigenereCipherAlgorithm()
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
    public void encrypt() {
         List<Integer> resultInt = new ArrayList<Integer>();
        String result = "";
        String aux = "";
        int m = getKey().length();
        int indexKey = 0;
        int[] keyIntegers = keyToIntegers(getKey());
        
      for(int i = 0; i < getPlainText().length(); i++)
      {
          if(getPlainText().charAt(i) != ' '){

            resultInt.add((ToolsAlgorithms.charToNumber( getPlainText().charAt(i)) + keyIntegers[indexKey]) % 26);
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
    public void decrypt() {
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

            resultInt.add(( ToolsAlgorithms.charToNumber( getCipherText().charAt(i)) - keyIntegers[indexKey]) % 26);
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
    
    public String calculateKey (String s){
             
             double[] pi={0.082, 0.015, 0.028, 0.043, 0.127, 0.022, 0.020,0.061,
                          0.070, 0.002, 0.008, 0.040, 0.024, 0.067, 0.075,0.019,
                          0.001, 0.060, 0.063, 0.091, 0.028, 0.010, 0.023, 0.001,
                          0.020, 0.001};

            int m = calculateM(s);
            
            System.out.println("--------------------------------------");
            
            Vector<String> y = new Vector<String>();
            double[][] vals = new double[m][26];
            double[][] ic = new double[m][26];
            setInfoKey("");
            Hashtable<Character,Integer> map = new Hashtable<Character, Integer>();
            String aux;
            for(int i = 0; i < m; i++){
                aux = "";
                for(int j=i; j<s.length();j += m){
                    aux += s.charAt(j);
                }
                y.add(aux);
                System.out.println("Y"+i+1 + " " + aux);
            }
             
            System.out.println("--------------------------------------");
           
            for(int i=0;i<m;i++)
           {
               for(int j=0;j<26;j++)
               {
                   vals[i][j]=0;
               }
           }

            int v=0;
            String yi;
            for(int i=0; i<y.size(); i++){
                map.clear();
                yi=y.get(i);
                setInfoKey(getInfoKey() + (i+1) + "   ");
                
                for(int c=0; c<yi.length(); c++)
                {
                    if(map.get(yi.charAt(c))==null)
                    {
                        map.put(yi.charAt(c),1);
                    }
                    else
                    {
                        map.put(yi.charAt(c),map.get(yi.charAt(c))+1);
                    }
                }
                  
                for(int k = 0; k<26 ;k++){
                    for(int j=0; j<26; j++){
                        if(map.get((char)((j+k+26)%26+97))==null)
                        {
                            v=0;
                        }
                        else 
                        {
                            v=map.get((char)((j+k+26)%26+97));
                        }
                        vals[i][k] += pi[j] * v /(double)yi.length();
                    }
                    ic[i][k] = vals[i][k];
                    vals[i][k] = Math.abs(vals[i][k] - 0.065);
                    setInfoKey(getInfoKey()  + (char)(97 + k) + ") " + Double.toString( ic[i][k]) + "  ") ;
                }
                setInfoKey(getInfoKey() + "\n") ;
            }
          // yi = "";
           
           String key = "";
           double min=Double.MAX_VALUE;
            
           for(int i=0; i<m; i++){
                min=Double.MAX_VALUE;
                for(int j=0; j<26 ;j++){

                   if(vals[i][j] < min){
                        min = vals[i][j];
                        v = j;
                    } 
                }
                System.out.println("v" + v);
                key += (char)(v + 97);
            }

            return key;

         }
         
    public int calculateM(String s){
             
            double distanceToIndex = Double.MAX_VALUE;
            double indexAux = 0;
            String aux = "";
            int M = -1;
            this.setInfoM("");
            
            for(int m = 1; distanceToIndex > 0.008; m++){
                indexAux = 0;
                for(int i = 1; i <= m; i++){
                    aux = "";
                    for(int j = i-1; j < s.length();j += m)
                    {
                        aux += s.charAt(j);
                    }
                    indexAux += coincidenceIndex(aux);
                }
                indexAux/= m;
                distanceToIndex = Math.abs(indexAux - 0.065);
                M = m;
                this.setInfoM(getInfoM() + Integer.toString(m) + "      " + Double.toString(indexAux) + "\n") ;  
            }
            System.err.println(this.getInfoM());
            System.out.println("Tamaño de la clave: " + M);
            return M;
                
        }
         
    public double coincidenceIndex (String s){

             int n = s.length();
            Hashtable<Character,Integer> map = new Hashtable<Character, Integer>();
            int num=1;
            double indice=0;
            
            for(int i=0;i<s.length();i++)
            {
                if(map.get(s.charAt(i))==null)
                {
                    map.put(s.charAt(i), 1);
                }
                else
                {
                    map.put(s.charAt(i),map.get(s.charAt(i))+1 );
                }
            }
                
            Vector<Integer> nums = new Vector<Integer>(map.values());
            
            for (Integer num1 : nums) {
                num = num1;
                indice = indice + num*(num-1);
            }
            
            indice = indice / (n*(n-1));
            return indice;
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
            keyIntegers[i] = ToolsAlgorithms.charToNumber(key.charAt(i));
        }
        return keyIntegers;
    }

    /**
     * @return the infoM
     */
    public String getInfoM() {
        return infoM;
    }

    /**
     * @param infoM the infoM to set
     */
    public void setInfoM(String infoM) {
        this.infoM = infoM;
    }

    /**
     * @return the infoKey
     */
    public String getInfoKey() {
        return infoKey;
    }

    /**
     * @param infoKey the infoKey to set
     */
    public void setInfoKey(String infoKey) {
        this.infoKey = infoKey;
    }
    
}
