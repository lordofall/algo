package com.pack.contest;

/*
Given a string s and an integer k.
Return the maximum number of vowel letters in any substring of s with length k.

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Input: s = "rhythms", k = 4
Output: 0
Explanation: We can see that s doesn't have any vowel letters.

s="tnfazcwrryitgacaabwm"
k = 4
output: 3
Constraints:

1 <= s.length <= 10^5
s consists of lowercase English letters.
1 <= k <= s.length
*/
 
public class Leet_190_02_TP {

	public static void main(String[] args) {
		Leet_190_02_TP obj = new Leet_190_02_TP();
		String s = "tnfazcwrryitgacaabwm"; int k = 4;
		
		System.out.println(obj.maxVowels(s, k));
	}
	
	public int maxVowels(String s, int k) {
		int max = countVowels(s.substring(0, k)); // initialize
		int lastSubstringVowelCount = max;
		for(int i = 1; i <= s.length()-k; i++) {
			int tmp = lastSubstringVowelCount;
			if(isVowel(s.charAt(i-1)) && tmp > 0) tmp--;
			if(isVowel(s.charAt(i+k-1))) tmp++;
			lastSubstringVowelCount = tmp;
			
			if(max < lastSubstringVowelCount)
				max = lastSubstringVowelCount;
			
		}
		return max;
    }
	public int countVowels(String s) {
		 int count = 0;
	        for(char c: s.toCharArray()) {
	        	if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
	        }
			return count;
	}
	
	public boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

}
