package com.pack.contest.sept;

public class Leet_208_01_TP {

	public static void main(String[] args) {
		Leet_208_01_TP obj = new Leet_208_01_TP();

//		String[] logs = {"d1/","d2/","../","d21/","./"}; // 2
//		String[] logs = {"d1/","d2/","./","d3/","../","d31/"}; // 3
		String[] logs = {"d1/","../","../","../"}; // 0
		
		System.out.println(obj.minOperations(logs));
	}

	
    public int minOperations(String[] logs) {
        int op = 0;
    	for(String log: logs) {
    		if(log.startsWith("..")) {
    			if(op > 0) op--;
    		}
    		else if(log.startsWith(".")) {
    			// do nothing
    		}
    		else {
    			op++;
    		}
    	}
    	return op;
    }

}
