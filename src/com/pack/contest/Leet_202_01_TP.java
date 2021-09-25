package com.pack.contest;

public class Leet_202_01_TP {

	public static void main(String[] args) {
		Leet_202_01_TP obj = new Leet_202_01_TP();
		int[] arr = {1,2,34,3,4,5,7,23,12};
		System.out.println(obj.threeConsecutiveOdds(arr));

	}

	public boolean threeConsecutiveOdds(int[] arr) {
		int count = 0;
		boolean result = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]%2 == 1) {
				count++;
			}
			else {
				count = 0;
			}
			if(count == 3) {
				result = true;
				break;
			}
		}
		return result;
    }
}
