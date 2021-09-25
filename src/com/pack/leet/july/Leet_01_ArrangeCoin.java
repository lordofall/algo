package com.pack.leet.july;
/*
 Arranging Coins
 You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
Given n, find the total number of full staircase rows that can be formed.
n is a non-negative integer and fits within the range of a 32-bit signed integer.
n = 5
output: 2

n = 8
output: 3
 */
public class Leet_01_ArrangeCoin {

	public static void main(String[] args) {
		Leet_01_ArrangeCoin obj = new Leet_01_ArrangeCoin();
		System.out.println(obj.arrangeCoins(8));
	}

	public int arrangeCoins(int n) {
		int i = 1;
		while(i <= n) {
			n = n - i;
			i++;
		}
		return i-1;
    }
}
