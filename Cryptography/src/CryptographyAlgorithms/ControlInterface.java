package CryptographyAlgorithms;

/**
 *
 * @author Miguel
 */


public interface ControlInterface {
    
    public String getName();
    //cifrar
    public void encrypt();
    //descifrar
    public void decrypt();
    //Clave del método empleado
    public void setKeys(Object keys); 
    public Object getKeys();
    public void setClearData(Object data);
    public Object getClearData();
    public void setCipherData(Object data);
    public Object getCipherData();
}