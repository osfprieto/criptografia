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
public class PrimoRelativo {
    private int dato;
    
    public int getDato (){
        return dato;
    }
    
    public void setDato (int val){
        this.dato = val;
    }
    
    public PrimoRelativo(){
        dato=0;
    }
    
    public PrimoRelativo (int dato){
        this.dato=dato;
    }
    
    public boolean verificarPrimoRelativo(int dato2){
        int divisor=2;
        boolean rta=true;
        while ((divisor<=dato/2) || (divisor<=dato2/2)){
            if(((dato % divisor)==0)&&((dato2 % divisor)==0))
                return (rta=false);
            divisor++;
        }
        return rta;
    }
}