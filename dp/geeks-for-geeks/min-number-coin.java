// Minimum number of Coins

// Given a value N, total sum you have. You have to make change for Rs. N, and there is infinite supply of each of the denominations in Indian currency, i.e., you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued coins/notes, Find the minimum number of coins and/or notes needed to make the change for Rs N.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Each test case consist of an Integer value N denoting the amount to get change for.

// Output:
// Print all the denominations needed to make the change in a separate line.

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 106

// Example:
// Input:
// 1
// 43

// Output:
// 20 20 2 1

// Explanation:
// Testcase 1: Sum of Rs 43 can be changed with minimum of 4 coins/ notes 20, 20, 2, 1.

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	   BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	   int t = Integer.parseInt(r.readLine());
	   while ( t-- > 0) {
	     int n = Integer.parseInt(r.readLine());
	   //  int[] dp = new int[n + 1];
	   //  dp[0] = 0;
	     int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
	   //  for (int i = 1; i <= n; ++i ) {
	   //      int val = Integer.MAX_VALUE;
	   //      for(int j = 0; j < coins.length ; ++j ) {
	   //          if(coins[j] > i) {
	   //              break;
	   //          }
	   //          val = Math.min(val, i/coins[j] + dp[i % coins[j]] );
	   //      }
	         
	   //  }
	     StringBuilder s = new StringBuilder();
	     int i = n, j = coins.length - 1;
	     while(i > 0) {
	         while(coins[j] > i){--j;}
	         for(int k = 0; k < i/coins[j]; ++k) {
	            s.append(String.valueOf(coins[j]) + " "); 
	            
	         }
	         i = i % coins[j];
	     }
	     
	     System.out.println(s);
	     
	   }
	  
	 }
}