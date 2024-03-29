package com.pack.leet.june;
/*
Dungeon Game
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

 */
public class Leet_21_Dungeon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int calculateMinimumHP(int[][] dungeon) {
		int r = dungeon.length;
		int c = dungeon[0].length;
		int[][] dp = new int[r][c];

		for (int i = r - 1; i >= 0; --i) {
			for (int j = c - 1; j >= 0; --j) {
				if (i == r - 1 && j == c - 1)
					dp[i][j] = Math.min(0, dungeon[i][j]);
				else if (i == r - 1)
					dp[i][j] = Math.min(0, dungeon[i][j] + dp[i][j + 1]);
				else if (j == c - 1)
					dp[i][j] = Math.min(0, dungeon[i][j] + dp[i + 1][j]);
				else
					dp[i][j] = Math.min(0, dungeon[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j]));
			}
		}
		return Math.abs(dp[0][0]) + 1;
	}
}
