package com.pack.leet.may;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {

	private static Map<String, Long> map = new HashMap<>();
    // Complete the getWays function below.
    static long getWays(long n, long[] c) {
        return countWays(n, c, 0);

    }

    /**
    * index starts from 0, if it reaces c.length, return 0
    */
    static long countWays(long n, long[] c, int index) {
        if(map.get(n+"_"+index) != null) return map.get(n+"_"+index);
        Long result = 0L;
        if (index == c.length) result = 0L;
        else if (n == 0) {
        	result = 1L;
        }
        else if (n < 0) {
        	result = 0L;
        }
        else {
        	result = countWays(n-c[index], c, index) + countWays(n, c, index+1);
        }
        map.put(n+"_"+index, result);
        return result; 
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        System.out.println(ways);
        /*bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();
        bufferedWriter.close();*/

        scanner.close();
    }
}
