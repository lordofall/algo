package com.pack.leet.may;
/*
 levenshtein distance
 Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */
public class Leet_32_EditDistance {

	public static void main(String[] args) {
		Leet_32_EditDistance obj = new Leet_32_EditDistance();
		String word1 = "horse"; String word2 = "ros";
		System.out.println(obj.minDistance(word1, word2));
	}
	
	
	public int minDistance(String source, String target) {
        int rows = target.length()+1;
        int cols = source.length()+1;
        int[][] dp = new int[rows][cols];
        
        // to convert
        // "" to "" -> 0 operation
        // a to "" -> 1 delete oprtation
        // ab to "" -> 2 delete operation
        // abc to "" -> 3 delete operation and so on
        
        for(int i = 0; i <= source.length(); i++)
        	dp[0][i] = i; // fill first row
        
        // to convert "" to "" -> 0 operation
        // to convert "" to a -> 1 insert operation
        // to convert "" to ab -> 2 insert operation and so on
        for(int i = 0; i <= target.length(); i++)
        	dp[i][0] = i; // fill first col
        
        
        // now fill rest of the 2 D array, rule is
        // if (character at ith row and jth column is same), 
        // then dp[i][j] = dp[i-1][j-1] .. as no extra operation is required
        // so to convert source(0,j) to target(0,i), the operation will be 
        // same as source(0, j-1) to target(0, i-1)
        // if character at ith row and jth col is not same
        // then 1 + min (operation(i-1,j), (i, j-1), (i-1, j-1) )
        
        for(int i = 1; i < rows; i++) {
        	for(int j = 1; j < cols; j++) {
        		if(target.charAt(i-1) == source.charAt(j-1))
        			dp[i][j] = dp[i-1][j-1];
        		else {
        			dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
        		}
        	}
        }
        
        return dp[rows-1][cols-1];
    }

}
