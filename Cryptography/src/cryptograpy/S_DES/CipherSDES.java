/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptograpy.S_DES;

/**
 *
 * @author Tato
 */
public class CipherSDES {
    
  private int[] K1 = new int[8];
  private int[] K2 = new int[8];
  private int[] pt = new int[8];
  private String plainText;
  private String cipherText;
  private SDESKey key;
  private boolean cifrar;
  
  
  void SaveParameters(String plaintext , int[] k1, int[] k2)
  {
	int[] pt = new int[8];
	
	/*
    int temp;
    for(int i=7;i>=0;i--)	
    {
      temp = plaintext % 10;
      pt[i] = temp;
      if(temp != 0 && temp != 1)
      {
        System.out.println("-- Error Occured : please enter valid 8-bit plaintext  ");
        System.exit(0);
		return;
      }      
      plaintext = plaintext/10;
    }
    */
		
	char c1;
	String ts ;
	
	try
	{
	for(int i=0;i<8;i++)
    {
       c1 = plaintext.charAt(i);
       ts = Character.toString(c1);
       pt[i] = Integer.parseInt(ts);
	   
	   if(pt[i] !=0 && pt[i]!=1)
	   {
		Print.msg("\n .. Invalid Plaintext ..");
		System.exit(0);
		return ;
	   }
    }
	}
	catch(Exception e)
	{
		Print.msg("\n .. Invalid Plaintext .. ");
		System.exit(0);
		return ;
		
	}
	
    this.pt = pt;
    
     Print.msg("Plaintext array : ");
     Print.array(this.pt,8);
	 Print.msg("\n");
	
    this.K1 = k1;
    this.K2 = k2;
    
    //Print.array(K1,8);
    //Print.msg("\n");
    //Print.array(K2,8);
  }
  
  /** perform Initial Permutation in following manner [2 6 3 1 4 8 5 7] **/
  void InitialPermutation()
  {
    int[] temp = new int[8];
    
    temp[0] = pt[1];
    temp[1] = pt[5];
    temp[2] = pt[2];
    temp[3] = pt[0];
    temp[4] = pt[3];
    temp[5] = pt[7];
    temp[6] = pt[4];
    temp[7] = pt[6];
    
    pt = temp;
	
	 Print.msg("Initial Permutaion(IP) : ");
     Print.array(this.pt,8);
	 Print.msg("\n");
	
  } 
  void InverseInitialPermutation()
  {
    int[] temp = new int[8];
    
    temp[0] = pt[3];
    temp[1] = pt[0];
    temp[2] = pt[2];
    temp[3] = pt[4];
    temp[4] = pt[6];
    temp[5] = pt[1];
    temp[6] = pt[7];
    temp[7] = pt[5];
    
    pt = temp;
	
	
  }
  
  /** mappingF . arguments 4-bit right-half of plaintext & 8-bit subkey **/ 
  int[] mappingF(int[] R, int[] SK)
  {
    int[] temp = new int[8];
    
    // EXPANSION/PERMUTATION [4 1 2 3 2 3 4 1] 
    temp[0]  = R[3];
    temp[1]  = R[0];
    temp[2]  = R[1];
    temp[3]  = R[2];
    temp[4]  = R[1];
    temp[5]  = R[2];
    temp[6]  = R[3];
    temp[7]  = R[0];
    
	 Print.msg("EXPANSION/PERMUTATION on RH : ");
     Print.array(temp,8);
	 Print.msg("\n");
	 
    // Bit by bit XOR with sub-key
    temp[0] = temp[0] ^ SK[0];
    temp[1] = temp[1] ^ SK[1];
    temp[2] = temp[2] ^ SK[2];
    temp[3] = temp[3] ^ SK[3];
    temp[4] = temp[4] ^ SK[4];
    temp[5] = temp[5] ^ SK[5];
    temp[6] = temp[6] ^ SK[6];
    temp[7] = temp[7] ^ SK[7];
    
	 Print.msg("XOR With Key : ");
     Print.array(temp,8);
	 Print.msg("\n");
	 
    // S-Boxes
    final int[][] S0 = { {1,0,3,2} , {3,2,1,0} , {0,2,1,3} , {3,1,3,2} } ;
    final int[][] S1 = { {0,1,2,3},  {2,0,1,3}, {3,0,1,0}, {2,1,0,3}} ;
    
   
      int d11 = temp[0]; // first bit of first half 
      int d14 = temp[3]; // fourth bit of first half
      
	  int row1 = BinaryOp.BinToDec(d11,d14); // for input in s-box S0
      
	  
      int d12 = temp[1]; // second bit of first half
      int d13 = temp[2]; // third bit of first half      
      int col1 = BinaryOp.BinToDec(d12,d13); // for input in s-box S0
      
	  
      int o1 = S0[row1][col1]; 
	      
	  int[] out1 = BinaryOp.DecToBinArr(o1);
	 
	 Print.msg("S-Box S0: ");
     Print.array(out1,2);
 	 Print.msg("\n");

	 int d21 = temp[4]; // first bit of second half
      int d24 = temp[7]; // fourth bit of second half
      int row2 = BinaryOp.BinToDec(d21,d24);
	  
	  int d22 = temp[5]; // second bit of second half
	  int d23 = temp[6]; // third bit of second half
	  int col2 = BinaryOp.BinToDec(d22,d23);
	  
	  int o2 = S1[row2][col2];
	  	 
	  int[] out2 = BinaryOp.DecToBinArr(o2); 

	 Print.msg("S-Box S1: ");
     Print.array(out2,2);
	 Print.msg("\n");
		
      //4 output bits from 2 s-boxes
	  int[] out = new int[4];
	  out[0] = out1[0];
      out[1] = out1[1];
	  out[2] = out2[0];
	  out[3] = out2[1];
	  
	  //permutation P4 [2 4 3 1]
	  
	  int [] O_Per = new int[4];
	  O_Per[0] = out[1];
	  O_Per[1] = out[3];
	  O_Per[2] = out[2];
      O_Per[3] = out[0];
	  
     Print.msg("Output of mappingF : ");
     Print.array(O_Per,4);
	 Print.msg("\n");  
	 
	 return O_Per;
  }
  
  /** fK(L, R, SK) = (L (XOR) mappingF(R, SK), R) .. returns 8-bit output**/
  int[] functionFk(int[] L, int[] R,int[] SK)
  {	
	int[] temp = new int[4];
	int[] out = new int[8];
	
	
	temp = mappingF(R,SK);
	
	
	//XOR left half with output of mappingF 
	out[0] = L[0] ^ temp[0];
	out[1] = L[1] ^ temp[1];
	out[2] = L[2] ^ temp[2];
	out[3] = L[3] ^ temp[3];
	
	out[4] = R[0];
	out[5] = R[1];
	out[6] = R[2];
	out[7] = R[3];
	
	
	return out;
	
	
  }
  
  /** switch function (SW) interchanges the left and right 4 bits **/
  int[] switchSW(int[] in)
  {
	
	int[] temp = new int[8];
	
	temp[0] = in[4];
	temp[1] = in[5];
	temp[2] = in[6];
	temp[3] = in[7];
  
    temp[4] = in[0];
	temp[5] = in[1];
	temp[6] = in[2];
	temp[7] = in[3];	
	
	return temp;
  }

  public String encrypt(String plaintext , int[] LK, int[] RK)
  {
	this.cipherText = "";
        if(this.cifrar == true)
        {
            plaintext = BinaryOp.textTOBinary(plaintext);
        }
        else if(this.cifrar == false)
        {
            plaintext = Integer.toBinaryString(Integer.parseInt(plaintext, 16)); //acá esta fallando
        }
        String plainText8Bits;
        
        for(int indexPT = 0; indexPT < plaintext.length(); indexPT += 8){
            plainText8Bits = "";
            for(int indexPT8Bits = indexPT; indexPT8Bits < indexPT + 8; indexPT8Bits++  ){
                plainText8Bits += plaintext.charAt(indexPT8Bits);
            }    
                SaveParameters(plainText8Bits,LK,RK);
                
                
                
                Print.msg("\n---------------------------------------\n");
                InitialPermutation();
                Print.msg("\n---------------------------------------\n");
                //saperate left half & right half from 8-bit pt
                int[] LH = new int[4];
                int[] RH = new int[4];
                LH[0] = pt[0];
                LH[1] = pt[1];
                LH[2] = pt[2];
                LH[3] = pt[3];


                RH[0] = pt[4];
                RH[1] = pt[5];
                RH[2] = pt[6];
                RH[3] = pt[7];


                 Print.msg("First Round LH : ");
             Print.array(LH,4);
                 Print.msg("\n");

                 Print.msg("First Round RH: ");
             Print.array(RH,4);
                 Print.msg("\n");

                //first round with sub-key K1
                int[] r1 = new int[8];
                r1 = functionFk(LH,RH,K1);

                 Print.msg("After First Round : ");
             Print.array(r1,8);
                 Print.msg("\n");
                Print.msg("\n---------------------------------------\n");
                //Switch the left half & right half of about output
                int[] temp = new int[8];
                temp = switchSW(r1);

                 Print.msg("After Switch Function : ");
             Print.array(temp,8);
                 Print.msg("\n");
                 Print.msg("\n---------------------------------------\n");
                // again saperate left half & right half for second round
                LH[0] = temp[0];
                LH[1] = temp[1];
                LH[2] = temp[2];
                LH[3] = temp[3];

                RH[0] = temp[4];
                RH[1] = temp[5];
                RH[2] = temp[6];
                RH[3] = temp[7];


                 Print.msg("Second Round LH : ");
             Print.array(LH,4);
                 Print.msg("\n");

                 Print.msg("Second Round RH: ");
             Print.array(RH,4);
                 Print.msg("\n");


                //second round with sub-key K2
                int[] r2 = new int[8];
                r2 = functionFk(LH,RH,K2);

                pt = r2;

                 Print.msg("After Second Round : ");
             Print.array(this.pt,8);
                 Print.msg("\n");
                 Print.msg("\n---------------------------------------\n");

                InverseInitialPermutation();

                 Print.msg("After Inverse IP (Result) : ");
             Print.array(this.pt,8);

             String cipherText = "";
             for(int i : pt)
             {
                 cipherText += String.valueOf(i);
             }

             int letra=0;
             for(int i = 0; i< cipherText.length(); i++)
             {
                 if(cipherText.charAt(cipherText.length() - (i+1)) == '1')
                 {
                     letra += Math.pow(2, i);
                 }
             }


             //System.out.println((char)letra);
             if(cifrar == true){
                this.cipherText += String.valueOf(Integer.toHexString(letra));
             }
             else if(cifrar == false)
             {
                 this.cipherText += (char)letra;
             }
             


                 Print.msg("\n");
            
        }
	//Encryption done... return 8-bit output .
	return this.cipherText;	
	
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

    /**
     * @return the key
     */
    public SDESKey getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(SDESKey key) {
        this.key = key;
    }

    public void cipher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the cifrar
     */
    public boolean isCifrar() {
        return cifrar;
    }

    /**
     * @param cifrar the cifrar to set
     */
    public void setCifrar(boolean cifrar) {
        this.cifrar = cifrar;
    }
}

class BinaryOp
{
 static String textTOBinary(String text)
 {
     byte[] b = text.getBytes();
        
        
      StringBuilder binary = new StringBuilder();
      for (byte letra : b)
      {
         int val = letra;
         for (int i = 0; i < 8; i++)
         {
            binary.append((val & 128) == 0 ? 0 : 1);
            val <<= 1;
         }
      }
      System.out.println("'" + text + "' to binary: " + binary);
      text = binary.toString();
      return text;
 }
    
  /** Gets binary digits as arguments & returns decimal number 
  for example input args [1,0,0] will return 4 **/ 
  static int BinToDec(int...bits)
  {     
     int temp=0;
     int base = 1;
     for(int i=bits.length-1 ; i>=0;i--)
     {
        temp = temp + (bits[i]*base);
        base = base * 2 ;
     }
      
      return temp;
  }
  
  /** gets decimal number as argument and returns array of binary bits 
  for example input arg [10] will return  [1,0,1,0]**/
  static int[] DecToBinArr(int no)
  {
    // 13 1
    // 6  0
    // 3  1
    // 1  1
    // 0  
    
	
	if(no==0)
	{
		int[] zero = new int[2];
		zero[0] = 0;
		zero[1] = 0;
		return zero;	
	}
    int[] temp = new int[10] ;
	
    
	int count = 0 ;
    for(int i= 0 ; no!= 0 ; i++)
    {
      temp[i] = no % 2;
      no = no/2;
	  count++;
    }
    
	
	int[] temp2 = new int[count];
	
	
	for(int i=count-1, j=0;i>=0 && j<count;i--,j++)
	{
		temp2[j] = temp[i];
	}
	
	//because we requires 2-bits as output .. so for adding leading 0
    if(count<2)
	{
		temp = new int[2];
		temp[0] = 0;
		temp[1] = temp2[0];
		return temp;
	}
	 
	return temp2;
  }
}
