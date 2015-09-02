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
    
    public static long gcd(long a, long b) {
        if (b==0)
            return a;
        return gcd(b,a%b);
    }
    
    //For testing
    public static void main(String[] args){
        //powermod
        System.out.println(powerMod(2, 5, 3)); // 2
        
        // mmult
        double[][] a = new double[5][3];
        double[][] b = new double[3][5];
        
        for(int i=0;i<15;i++){
            a[i/3][i%3] = 1;
            b[i/5][i%5] = 1;
        }
        
        printMatrix(a);
        printMatrix(b);
        printMatrix(mmult(a, b));
        
        //gcd
        System.out.println(gcd(23, 43));
    }
}