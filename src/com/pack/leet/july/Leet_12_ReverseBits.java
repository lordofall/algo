package com.pack.leet.july;
/*Reverse Bits
Reverse bits of a given 32 bits unsigned integer.

Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

 */
public class Leet_12_ReverseBits {

	public static void main(String[] args) {
		

	}
	
	
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
        	int lsb = n & 1;
        	int reverseLsb = lsb << (31-i);
        	result = result | reverseLsb;
        	n = n >> 1;
        }
        return result;
    }

}
