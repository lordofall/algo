package com.pack.contest;


/**
 * 1754. Largest Merge Of Two Strings
 * 
 * @author LordOfAll
 *
 */
public class Leet_227_03_TP {

	public static void main(String[] args) {
		Leet_227_03_TP obj = new Leet_227_03_TP();
//		String word1 = "cabaa", word2 = "bcaaa"; // cbcabaaaaa
//		String word1 = "abcabc", word2 = "abdcaba"; // abdcabcabcaba
//		String word1 = "aa", word2 = "aaa"; // abdcabcabcaba
		String word1 = "guguuuuuuuuuuuuuuguguuuuguug",
		word2 = "gguggggggguuggguugggggg"; // guguuuuuuuuuuuuuuguguuuuguugguggggggguuggguuggggggg
		String expected = "guguuuuuuuuuuuuuuguguuuuguugguggggggguuggguuggggggg";
		String outcome = obj.largestMerge(word1, word2); // "guguuuuuuuuuuuuuuguguuuuguuggguggggggguuggguugggggg"
		System.out.println(expected.equals(outcome));
	}

	public String largestMerge(String word1, String word2) {
		return merge(word1, word2, "");
	}

	private String merge(String word1, String word2, String merged) {
		if((word1 == null || word1.length() == 0) &&
				(word2 == null || word2.length() == 0)) {
			return merged;
		}
		
		if(word1 == null || word1.length() == 0)
			return merged+word2;
		
		if(word2 == null || word2.length() == 0)
			return merged+word1;
		
		if(word1.charAt(0) > word2.charAt(0)) {
			merged = merged + word1.charAt(0);
			word1 = word1.substring(1);
		}
		else if(word1.charAt(0) < word2.charAt(0)) {
			merged = merged + word2.charAt(0);
			word2 = word2.substring(1);
		}
		else { // equal
			int len = Math.min(word1.length(), word2.length());
			boolean wordsAreDiffrent = false;
			for(int i = 0; i < len; i++) {
				if(word1.charAt(i) != word2.charAt(i)) {
					if(word1.charAt(i) > word2.charAt(i)) {
						merged = merged + word1.charAt(0);
						word1 = word1.substring(1);
					}
					else {
						merged = merged + word2.charAt(0);
						word2 = word2.substring(1);
					}
					wordsAreDiffrent = true;
					break;
				}
			}
			
			if(!wordsAreDiffrent) {
				// get from who is bigger
				if(word1.length() > word2.length()) {
					merged = merged + word1.charAt(0);
					word1 = word1.substring(1);
				}
				else {
					merged = merged + word2.charAt(0);
					word2 = word2.substring(1);
				}
			}
		}
		
		return merge(word1, word2, merged);
	}

}
