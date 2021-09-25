package com.pack.contest;
/**
 * 1753. Maximum Score From Removing Stones
 * 
 * Constraints:

 * 1 <= a, b, c <= 10^5
 * 
 * 
 * In this problem if you want to use DP with memoization, dont as you wll have to create
 * int[][][] dp = new int[a+1][b+1][c+1];
 * and this can cause space problem.
 * @author LordOfAll
 *
 */
public class Leet_227_02_TP {

	public static void main(String[] args) {
		Leet_227_02_TP obj = new Leet_227_02_TP();
//		int a = 2, b = 4, c = 6; // 6
//		int a = 4, b = 4, c = 6; // 7
//		int a = 1, b = 8, c = 8; // 8
//		int a = 24, b = 19, c = 24; // 33
		int a = 1019, b = 375, c = 664; // 1029
		System.out.println(obj.maximumScore(a,b,c));

	}
	
	
	
	public int maximumScore(int a, int b, int c) {
		int[][][] dp = new int[a+1][b+1][c+1];
		return maximumScore(a, b, c, dp);
    }
	
	
	/**
	 * timeout 
	 * @param a
	 * @param b
	 * @param c
	 * @param dp
	 * @return
	 */
	public int maximumScore(int a, int b, int c, int[][][] dp) {
		if(a == 0 && b == 0 || a==0 && c == 0 || b ==0 && c == 0) 
			return 0;
		
		if(dp[a][b][c] != 0) return dp[a][b][c];
		
		int score1 = 0, score2 = 0, score3 = 0;
		if(a > 0 && b > 0) {
		    score1 = 1+ maximumScore(a-1, b-1, c, dp);
		   
		}
		if(a > 0 && c > 0 ) {
			score2 = 1+ maximumScore(a-1, b, c-1, dp); 
		}
			
		if(b > 0 && c > 0 ) {
			score3 = 1+ maximumScore(a, b-1, c-1, dp);
		}
		dp[a][b][c] =  Math.max(Math.max(score1, score2),score3);
		return dp[a][b][c];
			
    }
	
	/**
	 * Result is smaller of sum/2 and sum-max
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int maximumScore2(int a, int b, int c) {
        int sum=a+b+c;
        int max=Math.max(a,Math.max(b,c));
        return Math.min(sum/2,sum-max);
    }

}
