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
  The keys are given in a Long array with the following order
  [p, q, e]
  You should have in mind that the keys used should large enough so the module n
  can hold all the values that you want to parse. In this case we parse 
*/
public class RSACipherAlgorithm implements ControlInterface{

    private long n; // n = p*q
    private long fi_n; // fi_n = (p-1)*(q-1)
    private long p; // prime number, given in the keys.
    private long q; // prime number, given in the keys.
    private long e; // e < fi_n, gcd(e, fi_n) = 1, given in the keys.
    private long d; // e*d = 1 (mod fi_n), we can calculate it or we can get it in the keys.
    
    private String clearData;
    private String cipherData;
    
    @Override
    public String getName() {
        return "RSA";
    }

    @Override
    public void encrypt() {
        cipherData = "";
        clearData = clearData.trim().toLowerCase();
        for(int i=0;i<clearData.length();i++){
            char clearChar = clearData.charAt(i);
            int clearNumber = (int) clearChar;
            if(clearChar != ' '){ // We take out the spaces.
                long cipheredNumber = ToolsAlgorithms.powerMod(clearNumber, e, n);
                cipherData += cipheredNumber + ((i<clearData.length()-1)?",":"");
            }
        }
    }

    @Override
    public void decrypt() {
        clearData = "";
        for(String token : cipherData.trim().split(",")){
            long cipherNumber = Long.parseLong(token);
            long clearNumber = ToolsAlgorithms.powerMod(cipherNumber, d, n);
            clearData += (char)clearNumber;
        }
    }

    @Override
    public void setKeys(Object keys) {
        Long[] keysArray = (Long[])keys;
        p = keysArray[0];
        q = keysArray[1];
        e = keysArray[2];
        n = p*q;
        fi_n = (p-1)*(q-1);
        if(ToolsAlgorithms.gcd(e, fi_n)!=1){
            System.err.println("You're using an invalid public key, e should be coprime with fi_n, euler(n)");
        }
        d = ToolsAlgorithms.multiplicativeInverse(e, fi_n);
    }

    @Override
    public Object getKeys() {
        Long[] keys = new Long[3];
        keys[0] = p;
        keys[1] = q;
        keys[2] = e;
        return keys;
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
    
    // Public values.
    
    public long getN(){
        return n;
    }
    
    public long getD(){
        return d;
    }
    
    public long getE(){
        return e;
    }
    
    public long getFiN(){
        return fi_n;
    }
}
