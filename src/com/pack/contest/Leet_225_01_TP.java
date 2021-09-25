package com.pack.contest;

public class Leet_225_01_TP {

	public static void main(String[] args) {
		Leet_225_01_TP obj = new Leet_225_01_TP();
		
//		String time = "1?:22"; 
//		String time = "?4:03"; 
		String time = "??:3?";
		System.out.println(obj.maximumTime(time));

	}


    public String maximumTime(String time) {
    	
    			if(time.charAt(0) == '?') {
    				if(time.charAt(1) != '?' && time.charAt(1) > '3') {
    					time = time.replaceFirst("\\?", "1");
    				}
    				else {
    					time = time.replaceFirst("\\?", "2");
    				}
    				
    			}
    			
    			if(time.charAt(1) == '?') {
    				if(time.charAt(0) == '2') {
    					time = time.replaceFirst("\\?", "3");
    				}
    				else {
    					time = time.replaceFirst("\\?", "9");
    				}
    			}
    			if(time.charAt(3) == '?') {
    				time = time.replaceFirst("\\?", "5");
    			}
    			if(time.charAt(4) == '?') {
    				time = time.replaceFirst("\\?", "9");
    			}
    				
        return time;
    }
	
}
	

