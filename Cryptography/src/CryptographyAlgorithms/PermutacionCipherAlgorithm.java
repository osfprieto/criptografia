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

/*
 * 
 * La llave de este cifrado es una cadena de texto con el orden en el que se
 * reordenan los caracteres de cada bloque.
 * La cadena de texto estará compuesta por números en los que se debe reordenar
 * los bloques, cada número estará separado por comas usando índices desde 0.
 * 
 * Por ejemplo:
 * Cuando se usa m=6 y queremos que la primera posición (0) sea cambiada por
 * la cuarta posición (3), la segunda (1) por la letra de la tercera (2)
 * posición y así entre otros tendríamos la clave
 * 
 * 3, 2, 1, 4, 5, 0
 * 
 */
public class PermutacionCipherAlgorithm implements ControlInterface{

    private String clearData;
    private String cipherData;
    private int indexes[];
    private int indexesDecipher[];
    
    @Override
    public String getName() {
        return "Cifrado por permutación";
    }

    @Override
    public void encrypt() {
        cipherData = "";
               
        int index = 0;
        int count = 0;
        int m = indexes.length;
        
        while(clearData.length()%m!=0)
            clearData += " ";

        
        for(int i=0;i<clearData.length();i++){
            cipherData += clearData.charAt(m*count+indexes[index]);
                    
            index++;
            index%=m;
            if(index==0)
                count++;
        }
    }

    @Override
    public void decrypt() {
        clearData = "";
        
        int index = 0;
        int count = 0;
        int m = indexes.length;
        
        while(cipherData.length()%m!=0)
            cipherData += " ";
        
        for(int i=0;i<cipherData.length();i++){
            clearData += cipherData.charAt(m*count+indexesDecipher[index]);
                    
            index++;
            index%=m;
            if(index==0)
                count++;
        }
    }

    @Override
    public void setKeys(Object keys) {
        String key = (String) keys;
        String tokens[] = key.trim().split(",");
        indexes = new int[tokens.length];
        for(int i=0;i<tokens.length;i++){
            indexes[i] = Integer.parseInt(tokens[i].trim());
        }
        
        indexesDecipher = new int[indexes.length];
        for(int i=0;i<indexes.length;i++){
            int j=0;
            while(indexes[j]!=i)
                j++;
            indexesDecipher[i]=j;
        }
    }

    @Override
    public Object getKeys() {
        String keys = "";
        for(int index : indexes){
            keys+=index+", ";
        }
        return keys.trim();
    }

    @Override
    public void setClearData(Object data) {
        clearData = (String) data;
    }

    @Override
    public Object getClearData() {
        return clearData;
    }

    @Override
    public void setCipherData(Object data) {
        cipherData = (String) data;
    }

    @Override
    public Object getCipherData() {
        return cipherData;
    }
    
}
