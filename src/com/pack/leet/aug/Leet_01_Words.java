package com.pack.leet.aug;

public class Leet_01_Words {

	public static void main(String[] args) {

	}

	public boolean detectCapitalUse(String word) {
        if(word.equals(word.toUpperCase()))
            return true;
        
        if(word.equals(word.toLowerCase()))
            return true;
        
        String first = String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1).toLowerCase();
        if(word.equals(first))
            return true;
        
        return false;
    }
}
