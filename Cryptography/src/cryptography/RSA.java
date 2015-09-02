/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author OmarSimónFrancisco
 */
public class RSA implements Algorithm{

    private long n; // n = p*q
    private long fi_n; // fi_n = (p-1)*(q-1)
    private long p; // prime number, given in the keys.
    private long q; // prime number, given in the keys.
    private long e; // e < fi_n, gcd(e, fi_n) = 1, given in the keys.
    private long d; // e*d = 1 (mod fi_n), we can calculate it or we can get it in the keys.
    
    @Override
    public String getName() {
        return "RSA";
    }

    @Override
    public void cipher() {
        
    }

    @Override
    public void decipher() {
        
    }

    @Override
    public void setKeys(Object keys) {
        
    }

    @Override
    public Object getKeys() {
        return null;
    }

    @Override
    public void setClearData(Object data) {
        
    }

    @Override
    public Object getClearData() {
        return null;
    }

    @Override
    public void setCipherData(Object data) {
        
    }

    @Override
    public Object getCipherData() {
        return null;
    }
    
    // Public values.
    
    public long getN(){
        return n;
    }
    
    public long getE(){
        return e;
    }
}
