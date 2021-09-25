package com.pack.contest;

/**
 * 5734. Check if the Sentence Is Pangram
 * ACCEPTED
 * @author LordOfAll
 *
 */
public class Leet_237_01_TP {

	public static void main(String[] args) {
		Leet_237_01_TP obj = new Leet_237_01_TP();
//		String sentence = "thequickbrownfoxjumpsoverthelazydog";//true
		String sentence = "leetcode";//false
		System.out.println(obj.checkIfPangram(sentence));
	}


    public boolean checkIfPangram(String sentence) {
    	boolean result =false;
    	int count = 0;
    	int[] arr = new int[26];
    	
    	for(char c: sentence.toCharArray()) {
    		if(arr[c-97] == 0) {
    			arr[c-97] = 1;
    			count++;
    		}
    		if(count == 26) {
    			result= true;
    			break;
    		}
    	}
        return result;
    }
}
