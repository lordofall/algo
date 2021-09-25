package com.pack.leet.may;

import java.util.ArrayList;
import java.util.HashMap;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Hint:
This problem is equivalent to finding if a cycle exists in a directed graph. 
If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.

Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of 
Topological Sort.

Topological sort could also be done via BFS.

Example:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
public class Leet_30_CourseSchedule {

	public static void main(String[] args) {
		Leet_30_CourseSchedule obj = new Leet_30_CourseSchedule();
//		int numCourses = 2;
//		int[][] prerequisites = new int[][] {new int[] {1,0}};
//		System.out.println(obj.canFinish(numCourses, prerequisites));
		
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}} ;
		System.out.println(obj.canFinish(numCourses, prerequisites));
		
		
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    if(prerequisites == null){
	        throw new IllegalArgumentException("illegal prerequisites array");
	    }
	 
	    int len = prerequisites.length;
	 
	    if(numCourses == 0 || len == 0){
	        return true;
	    }
	 
	    //track visited courses
	    int[] visit = new int[numCourses];
	 
	    // use the map to store what courses depend on a course 
	    HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
	    for(int[] a: prerequisites){
	        if(map.containsKey(a[1])){
	            map.get(a[1]).add(a[0]);
	        }else{
	            ArrayList<Integer> l = new ArrayList<>();
	            l.add(a[0]);
	            map.put(a[1], l);
	        }
	    }
	 
	    for(int i=0; i<numCourses; i++){
	    	System.out.println("finding dfs from "+ i);
	    	if(!canFinishDFS(map, visit, i))
	            return false;
	        
	    	System.out.println("found dfs from "+ i);
	    }
	 
	    return true;
	}
	 
	private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, int[] visit, int i){
	    if(visit[i]==-1) 
	        return false;
	    if(visit[i]==1) 
	        return true;
	 
	    visit[i]=-1;
	    if(map.containsKey(i)){
	        for(int j: map.get(i)){
	            if(!canFinishDFS(map, visit, j)) 
	                return false;
	        }
	    }
	 
	    visit[i]=1;
	 
	    return true;
	}
}
