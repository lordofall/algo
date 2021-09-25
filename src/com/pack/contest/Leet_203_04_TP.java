package com.pack.contest;

public class Leet_203_04_TP {

	public static void main(String[] args) {
		Leet_203_04_TP obj = new Leet_203_04_TP();
		int[] arr = {1,2,34,3,4,5,7,23,12};
//		System.out.println(obj.threeConsecutiveOdds(arr));

	}
	
	public int stoneGameV(int[] stoneValue) {
        int point = 0;
        int left = 0;
        int right = stoneValue.length-1;
        point = play(stoneValue, left, right, point);
        return point;
    }

	private int play(int[] stoneValue, int left, int right,int point) {
		if(left == right)
			return point + stoneValue[left];
		
		int total = 0;
		for(int i = left; i <= right; i++)
			total += stoneValue[i];
		
		int mid = left;
		int leftCount = 0;
		int tmpPoint = 0;
		while(mid < right) {
			leftCount = leftCount + stoneValue[mid];
			int rightCount = total - leftCount;
			if(leftCount < rightCount) {
				tmpPoint = leftCount;
			}
			else {
				break;
			}
			mid++;
		}
		mid = mid-1;
		
//		return tmpPoint + play(stoneValue, );
		return 0;
	}
}
