package com.pack.leet.july;

import java.util.LinkedList;

/*
Course Schedule II
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

 */
public class Leet_18_CourseSchedule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findOrder2(int numCourses, int[][] prerequisites) {
		return null;
	}
	
	// copied
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		 if(prerequisites == null){
		        throw new IllegalArgumentException("illegal prerequisites array");
		    }
		 
		    int len = prerequisites.length;
		 
		    //if there is no prerequisites, return a sequence of courses
		    if(len == 0){
		        int[] res = new int[numCourses];
		        for(int m=0; m<numCourses; m++){
		            res[m]=m;
		        }
		        return res;
		    }
		 
		    //records the number of prerequisites each course (0,...,numCourses-1) requires
		    int[] pCounter = new int[numCourses];
		    for(int i=0; i<len; i++){
		        pCounter[prerequisites[i][0]]++;
		    }
		 
		    //stores courses that have no prerequisites
		    LinkedList<Integer> queue = new LinkedList<Integer>();
		    for(int i=0; i<numCourses; i++){
		        if(pCounter[i]==0){
		            queue.add(i);
		        }
		    }
		 
		    int numNoPre = queue.size();
		 
		    //initialize result
		    int[] result = new int[numCourses];
		    int j=0;
		 
		    while(!queue.isEmpty()){
		        int c = queue.remove();
		        result[j++]=c;
		 
		        for(int i=0; i<len; i++){
		            if(prerequisites[i][1]==c){
		                pCounter[prerequisites[i][0]]--;
		                if(pCounter[prerequisites[i][0]]==0){
		                    queue.add(prerequisites[i][0]);
		                    numNoPre++;
		                }
		            }
		 
		        }
		    }
		 
		    //return result
		    if(numNoPre==numCourses){
		        return result;
		    }else{
		        return new int[0];
		    }
        
    }
	
	
	
	

}
