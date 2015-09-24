/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/*
 * Class with different methods that will come in handy when implementing the
 * cipher algorithms.
 */
public class Util {
    
    // Returns the value for (base^pow) % mod;
    public static  long  powerMod(long base, long pow, long mod) {
        long  tempo;
        if (pow == 0){
            tempo =  1;
        }
        else if (pow == 1)
            tempo = base;
        else {
            long temp = powerMod(base,pow/2,mod);
            if (pow%2 == 0)
                tempo = (temp*temp)%mod;
            else
                tempo = ((temp*temp)%mod)*base%mod;
        }
        return tempo;
    }
    
    // Returns the matrix C(axb) = A(axn) * B(nxb)
    // The number of columns in A should be the same number of rows of B
    public static double[][] mmult(double[][] a, double[][] b){
        double[][] c = new double[a.length][b[0].length];
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                c[i][j] = 0;
                for(int k=0;k<b.length;k++){
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    
    public static long[][] mmult(long[][] a, long[][] b){
        long[][] c = new long[a.length][b[0].length];
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                c[i][j] = 0;
                for(int k=0;k<b.length;k++){
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    
    public static void printMatrix(double[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++)
                System.out.print(a[i][j]+", ");
            System.out.println();
        }
    }
    
    public static void printMatrix(long[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++)
                System.out.print(a[i][j]+", ");
            System.out.println();
        }
    }
    
    // Finds the greatest common divisor for a and b
    public static long gcd(long a, long b) {
        if (b==0)
            return a;
        return gcd(b,a%b);
    }
    
    // Finds a the shortest positive value b such (a*b)%mod is 1
    // Using brute force right now, should use the Extended Euclidean Algorithm.
    public static long multiplicativeInverse(long a, long mod){
        a %= mod;
        long b = 1;
        while(b<mod && (a*b)%mod!=1)
            b++;
        if(b==mod)
            return -1;
        return b;
    }
    
    // Parses a char and turns the value into a number between 0 and 25, inclusive.
    public static int charToNumber(char c){
        int d = c-'a';
        if(d>=0 && d<=25)
            return d;
        d = c-'A';
        if(d>=0 && d<=25)
            return d;
        if(c=='á' || c=='Á')
            return 'a'-'a';
        if(c=='é' || c=='É')
            return 'a'-'e';
        if(c=='í' || c=='Í')
            return 'a'-'i';
        if(c=='ó' || c=='Ó')
            return 'a'-'o';
        if(c=='ú' || c=='Ú')
            return 'a'-'u';
        System.err.println("Warning: Trying to parse an unkown character");
        return 0;
    }
    
    // parses a number between 0 and 25, inclusive into a non capital character.
    public static char numberToChar(int number){
        if(number<0 || number>25)
            System.err.println("Trying to parse an out of bounds number into a character");
        return (char) ('a'+number);
    }
}