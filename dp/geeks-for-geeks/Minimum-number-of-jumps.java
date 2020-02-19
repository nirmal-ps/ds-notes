// Given an array of integers where each element represents the max number of steps that can be made forward from that element. The task is to find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

// Input: 
// The first line contains an integer T, depicting total number of test cases.  Then following T lines contains a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.

// Output:
// For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print "-1"(without quotes).

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 107
// 0 <= ai <= 107

// Example:
// Input:
// 2
// 11
// 1 3 5 8 9 2 6 7 6 8 9
// 6
// 1 4 3 2 6 7
// Output:
// 3
// 2

// Explanation:
// Testcase 1: First jump from 1st element, and we jump to 2nd element with value 3. Now, from here we jump to 5h element with value 9. and from here we will jump to last.
 

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	   BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	   int t = Integer.parseInt(r.readLine());
	   while(t-- > 0) {
	       int n = Integer.parseInt(r.readLine());
	       String[] s = r.readLine().trim().split("\\s+");
	       int[] A = new int[n];
	       
	       for (int i = 0; i < n; ++i) {
	           A[i] = Integer.parseInt(s[i]);
	       }
	       
	       int[] dp = new int[n];
	       Arrays.fill(dp, Integer.MAX_VALUE);
	       dp[0] = 0;
	       
	       for (int i = 0; i < n; ++i ) {
	         if (dp[i] == Integer.MAX_VALUE ) {
	             
	             System.out.println(-1);
	             break;
	         }    
	         for (int j = 1; j <= A[i]; ++j) {
	             int index = i + j;
	             if (index >= n ) {
	                 break;
	             }
	             dp[index] = Math.min(dp[index], dp[i] + 1);
	             
	             if (index == n - 1) {
	                 System.out.println(dp[index]);
	                 i = n;
	                 break;
	             }
	         }
	       }
	       
	       //System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]  );
	       
	   }
	 }
}