/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptograpy.S_DES;

import java.util.*;

/**
 *
 * @author Tato
 */
public class SDESKey {
    
    
  private int[] key = new int[10];
  private int[] k1 = new int[8];
  private int[] k2 = new int[8];
  private boolean flag = false;
  private String p10;
  private String p8;
  

    public SDESKey() {
        
    }
  
  public void GenerateKeys(String inputkey )
  {
    int[] key = new int[10];
	/*
    int temp;
    for(int i=9;i>=0;i--)
    {
      temp = inputkey % 10;
      key[i] = temp;
      if(temp != 0 && temp != 1)
      {
        System.out.println("-- Error Occured : Invalid Key ");
		System.exit(0);
        return;
      }      
      inputkey = inputkey/10;
    }
    */
	
	char c1;
	String ts ;
	
	try
	{
	for(int i=0;i<10;i++)
    {
       c1 = inputkey.charAt(i);
       ts = Character.toString(c1);
       key[i] = Integer.parseInt(ts);
	   
	   if(key[i] !=0 && key[i]!=1)
	   {
		Print.msg("\n .. Invalid Key ..");
		System.exit(0);
		return ;
	   }
    }
	}
	catch(Exception e)
	{
		Print.msg("\n .. Invalid Key .. ");
		System.exit(0);
		return ;
		
	}
        this.setKey(key);
    
	  Print.msg("Input Key : ");
      Print.array(this.getKey(),10);
      Print.msg("\n");
    
      permutationP10();
    
      Print.msg("After Permutation(P10) Key : ");
      Print.array(this.getKey(),10);
      Print.msg("\n");
    
      leftshiftLS1();
    
      Print.msg("After LeftShift LS-1 Key : ");
      Print.array(this.getKey(),10);
      Print.msg("\n");
    
    
      this.setK1(permutationP8());

     Print.msg("Subkey K1 Generated : ");
    // Print.array(this.getK1(),8);
     Print.msg("\n");
    
      leftshiftLS2();
  
     Print.msg("After LeftShift LS-2 Key : ");
    // Print.array(this.getKey(),10);
	 Print.msg("\n");
    
         this.setK2(permutationP8());
     Print.msg("Subkey K2 Generated : ");
    // Print.array(this.getK2(),8);
     Print.msg("\n"); 
    
    flag = true;

}
  
  /** Perform permutation P10 on 10-bit key 
  P10(k1, k2, k3, k4, k5, k6, k7, k8, k9, k10) = (k3, k5, k2, k7, k4, k10, k1, k9, k8, k6)
  **/
   
  private void permutationP10()
  {
    int[] temp = new int[10];
    
    temp[0] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(0)))];
    temp[1] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(1)))];
    temp[2] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(2)))];
    temp[3] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(3)))];
    temp[4] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(4)))];
    temp[5] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(5)))];
    temp[6] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(6)))];
    temp[7] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(7)))];
    temp[8] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(8)))];
    temp[9] = getKey()[Integer.parseInt(String.valueOf(this.p10.charAt(9)))];
    
    setKey(temp);
        
  }
  
  /** Performs a circular left shift (LS-1), or rotation, separately on the first
five bits and the second five bits. **/

  private void leftshiftLS1()
  {
    int[] temp = new int[10];
    
    temp[0] = getKey()[1];
    temp[1] = getKey()[2];
    temp[2] = getKey()[3];
    temp[3] = getKey()[4];
    temp[4] = getKey()[0];
    
    temp[5] = getKey()[6];
    temp[6] = getKey()[7];
    temp[7] = getKey()[8];
    temp[8] = getKey()[9];
    temp[9] = getKey()[5];
    
        setKey(temp);
    
  }
  
  /** apply Permutaion P8, which picks out and permutes 8 of the 10 bits according to the following 
  rule: P8[ 6 3 7 4 8 5 10 9 ] , 8-bit subkey is returned **/
  private int[] permutationP8()
  {
    int[] temp = new int[8];
    
    temp[0] = getKey()[Integer.parseInt(String.valueOf(this.p8.charAt(0)))];
    temp[1] = getKey()[Integer.parseInt(String.valueOf(this.p8.charAt(1)))];
    temp[2] = getKey()[Integer.parseInt(String.valueOf(this.p8.charAt(2)))];
    temp[3] = getKey()[Integer.parseInt(String.valueOf(this.p8.charAt(3)))];
    temp[4] = getKey()[Integer.parseInt(String.valueOf(this.p8.charAt(4)))];
    temp[5] = getKey()[Integer.parseInt(String.valueOf(this.p8.charAt(5)))];
    temp[6] = getKey()[Integer.parseInt(String.valueOf(this.p8.charAt(6)))];
    temp[7] = getKey()[Integer.parseInt(String.valueOf(this.p8.charAt(7)))];
    
    return temp;
        
  }
  
  private void leftshiftLS2()
  {
    int[] temp = new int[10];
    
    temp[0] = getKey()[2];
    temp[1] = getKey()[3];
    temp[2] = getKey()[4];
    temp[3] = getKey()[0];
    temp[4] = getKey()[1];
    
    temp[5] = getKey()[7];
    temp[6] = getKey()[8];
    temp[7] = getKey()[9];
    temp[8] = getKey()[5];
    temp[9] = getKey()[6];
    
        setKey(temp);
    
  }


public int[] getK1()
{
  if(!flag)
    {
      Print.msg("\nError Occured: Keys are not generated yet ");
      return null;
    }
    return k1;
}

public int[] getK2()
{
  if(!flag)
    {
      Print.msg("\nError Occured: Keys are not generated yet ");
      return null;
    }
    return k2;
}  

    /**
     * @return the key
     */
    public int[] getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(int[] key) {
        this.key = key;
    }

    /**
     * @return the p10
     */
    public String getP10() {
        return p10;
    }

    /**
     * @param p10 the p10 to set
     */
    public void setP10(String p10) {
        this.p10 = p10;
    }

    /**
     * @return the p8
     */
    public String getP8() {
        return p8;
    }

    /**
     * @param p8 the p8 to set
     */
    public void setP8(String p8) {
        this.p8 = p8;
    }

    /**
     * @param k1 the k1 to set
     */
    public void setK1(int[] k1) {
        this.k1 = k1;
    }

    /**
     * @param k2 the k2 to set
     */
    public void setK2(int[] k2) {
        this.k2 = k2;
    }

    
}

class Print
{
  /** Prints array to console  **/
  static void array(int[] arr,int len)
  {
    System.out.print(" - ");
   
    for(int i=0;i<len;i++)
    {
      System.out.print(arr[i] + " ");
    }
  }
  
  static void msg(String msg)
  {
    System.out.print(msg);
  }
}
