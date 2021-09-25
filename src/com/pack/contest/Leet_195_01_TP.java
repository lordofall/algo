package com.pack.contest;

import java.util.HashSet;
import java.util.Set;

/*
 *ACCEPTED
Path crossing

Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return True if the path crosses itself at any point, that is, if at any time you are on a location you've previously visited. Return False otherwise.

Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.

Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.

1 <= path.length <= 10^4
path will only consist of characters in {'N', 'S', 'E', 'W}
 */
public class Leet_195_01_TP {

	public static void main(String[] args) {
		Leet_195_01_TP o = new Leet_195_01_TP();
		System.out.println(o.isPathCrossing("NESWW")); //t
		/*System.out.println(o.isPathCrossing("NES"));//f
		System.out.println(o.isPathCrossing("NEES"));//f
		System.out.println(o.isPathCrossing("NEESWN"));*/
	}
	
	public boolean isPathCrossing(String path) {
		Set<String> visited = new HashSet<>();
		int x = 0;
		int y = 0;
		visited.add(x+""+y);
		for(int i = 0; i < path.length(); i++) {
			if(path.charAt(i) == 'N') {
				y++;
			}
			else if(path.charAt(i) == 'S') {
				y--;
			}
			else if(path.charAt(i) == 'E') {
				x++;
			}
			else if(path.charAt(i) == 'W') {
				x--;
			}
			String currentPosition = x+""+y;
			if(visited.contains(currentPosition))
				return true;
			visited.add(currentPosition);
		}
		return false;
	}

}
