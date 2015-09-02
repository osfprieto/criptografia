package cryptography;

// This interface sets up the behaviour of the algorithms to use in the project,
// The general behaviour and use of instances of this interface is:
// - To cipher:
//   1. setClearData
//   2. setKeys
//   3. cipher
//   4. getCiphereData
// - To decipher:
//   1. setCipherData
//   2. setKeys
//   3. decipher
//   4. getClearData

public interface Algorithm {

    // Returns the name of the algorithm, just so you're not flying blind.
    public String getName();

    // Clear data to ciphered data.
    public void cipher();
    // Ciphered data to clear data.
    public void decipher();

    // Could be any kind of object for the keys and data, such as a string,
    // array of integers, double, image buffer. But should be specified
    // and checked by the developer before storing the values (cast it)
    public void setKeys(Object keys); 
    public Object getKeys();
    
    // Sets the clear data to be ciphered by the instance of the algorithm.
    public void setClearData(Object data);
    // Retreives the clear data to be ciphered.
    public Object getClearData();
    // Sets the ciphered data to be deciphered by the instance of the algorithm.
    public void setCipherData(Object data);
    // Retrieves the ciphered data to be deciphered.
    public Object getCipherData();
}
