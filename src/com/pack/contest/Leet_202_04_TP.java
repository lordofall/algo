package com.pack.contest;
/*
 * 5490. Minimum Number of Days to Eat N Oranges
There are n oranges in the kitchen and you decided to eat some of these oranges every day as follows:

Eat one orange.
If the number of remaining oranges (n) is divisible by 2 then you can eat  n/2 oranges.
If the number of remaining oranges (n) is divisible by 3 then you can eat  2*(n/3) oranges.
You can only choose one of the actions per day.

Return the minimum number of days to eat n oranges.
 */

import java.util.HashMap;
import java.util.Map;

public class Leet_202_04_TP {

	Map<Integer, Integer> mem = new HashMap<>();

	public static void main(String[] args) {
		Leet_202_04_TP obj = new Leet_202_04_TP();
//		 int n = 540; //8
//		 int n = 651581;
//		 int n = 56; // 6
		// int n = 6; // 3
		int n = 10; // 4
		System.out.println(obj.minDays(n));

	}

	public int minDays(int n) {
		if (mem.containsKey(n)) {
			return mem.get(n);
		}
		if (n == 0)
			return 0;

		int n2 = Integer.MAX_VALUE;
		int n3 = Integer.MAX_VALUE;
//		int n1 = n;
		if (n % 3 == 0) {
			int remaining = n - 2 * (n / 3);
			n3 = 1 + minDays(remaining);
		}
		if (n % 2 == 0) {
			int remaining = n - n / 2;
			n2 = 1 + minDays(remaining);
		}
		int n1 = 1 + minDays(n - 1);
		
		int result = Math.min(n1,Math.min(n2, n3));

		if (!mem.containsKey(n))
			mem.put(n, result);
		return result;
	}

	// stackoverflow error for 651581
	int minDays2(int n) {
		if (mem.containsKey(n)) {
			return mem.get(n);
		}
		if (n == 0)
			return 0;

		int n2 = Integer.MAX_VALUE;
		int n3 = Integer.MAX_VALUE;

		int n1 = 1 + minDays(n - 1);

		if (n % 2 == 0) {
			int remaining = n - n / 2;
			n2 = 1 + minDays(remaining);
		}

		if (n % 3 == 0) {
			int remaining = n - 2 * (n / 3);
			n3 = 1 + minDays(remaining);
		}
		int result = Math.min(n1, Math.min(n2, n3));
		mem.put(n, result);
		return result;
	}
}
