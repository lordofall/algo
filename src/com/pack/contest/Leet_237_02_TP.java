package com.pack.contest;

import java.util.Arrays;

/**
 * 5735. Maximum Ice Cream Bars
 * ACCEPTED
 * @author LordOfAll
 *
 */
public class Leet_237_02_TP {

	public static void main(String[] args) {
		Leet_237_02_TP obj = new Leet_237_02_TP();
//		int[] costs = {1,3,2,4,1}; int coins = 7;// 4
//		int[] costs = {10,6,8,7,7,8}; int coins = 5;// 0
		int[] costs = {1,6,3,1,2,5}; int coins = 20;// 6
		int result = obj.maxIceCream(costs, coins);
		System.out.println(result);


	}


	public int maxIceCream(int[] costs, int coins) {
        int result = 0;
        Arrays.sort(costs);
        int i = 0;
        while(coins > 0 && i < costs.length) {
        	if(costs[i] <= coins) {
        		result++;
        		coins = coins - costs[i];
        	}
        	else
        		break;
        	i++;
        }
        return result;
    }
	
}
