package com.pack.contest;

public class leet_201_02_TP {

	public static void main(String[] args) {
		leet_201_02_TP obj = new leet_201_02_TP();
		int n = 3, k = 1;
		System.out.println(obj.findKthBit(n, k));
	}
	
	
	public char findKthBit(int n, int k) {
		String s = getBinaryString(n);
        return s.charAt(k-1);
    }
	
	private String getBinaryString(int n) {
		String[] dp = new String[n];
		dp[0] = "0";
		for(int i = 1; i < n; i++) {
			dp[i] = dp[i-1]+"1"+reverseAndInvert(dp[i-1]);
		}
  		return dp[n-1];
	}


	String reverseAndInvert(String s) {
		StringBuilder result = new StringBuilder();
		for(int i = s.length()-1; i >=0; i--) {
			if(s.charAt(i) == '1')
				result.append('0');
			else
				result.append('1');
		}
		return result.toString();
	}
	
	
}
