package com.pack.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 Making File Names Unique
Given an array of strings names of size n. You will create n folders in your file system such that, 
at the ith minute, you will create a folder with the name names[i].

Since two files cannot have the same name, if you enter a folder name which is previously used, 
the system will have a suffix addition to its name in the form of (k), where, k is the smallest positive integer
 such that the obtained name remains unique.

Return an array of strings of length n where ans[i] is the actual name the system will assign to the
ith folder when you create it.

Input: names = ["wano","wano(1)","wano","wano"]
Output: ["wano","wano(1)","wano(2)","wano(3)"]
Explanation: Just increase the value of k each time you create folder "wano".

Input: names = ["kaido","kaido(1)","kaido","kaido(1)"]
output: ["kaido","kaido(1)","kaido(2)","kaido(1)"]
Constraints:
1 <= names.length <= 5 * 10^4
1 <= names[i].length <= 20
names[i] consists of lower case English letters, digits and/or round brackets.
*/
public class Leet_194_02_UniqueFileNames {

	
	public static void main(String[] args) {
		Leet_194_02_UniqueFileNames obj = new Leet_194_02_UniqueFileNames();
		String[] names = {"kaido","kaido(1)","kaido","kaido(1)"};
		System.out.println(Arrays.toString(obj.getFolderNames(names)));
	
	}
	Map<String, Integer> map = new HashMap<>();
	public String[] getFolderNames(String[] names) {
		String[] result = new String[names.length];
		for(int i = 0; i < names.length; i++) {
			String namewoPar = names[i];
			int folderNumber = 0;
			if(names[i].contains("(")) {
				folderNumber = Integer.parseInt(names[i].substring(names[i].indexOf('(')+1, names[i].indexOf(')')));
				namewoPar = names[i].substring(0, names[i].indexOf('('));
			}
				
			
			if(map.keySet().contains(namewoPar)) {
				if(folderNumber > map.get(namewoPar)) {
					result[i] = names[i];
				}
				else {
					folderNumber = map.get(namewoPar)+1;
					result[i]= namewoPar+"("+folderNumber+")";
				}
				map.put(namewoPar, folderNumber);
			}
			else {
				result[i] = names[i];
				map.put(namewoPar, folderNumber);
			}

		}
		return result;
    }	
	
}
