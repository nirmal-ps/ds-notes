// Given a sequence A of size N, find the length of the longest increasing subsequence from a given sequence .
// The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

// Note: Duplicate numbers are not counted as increasing subsequence.

// Input:
// The first line contains an integer T, depicting total number of test cases. Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.

// Output:
// For each testcase, in a new line, print the Max length of the subsequence in a separate line.

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 1000
// 0 ≤ A[i] ≤ 300

// Example:
// Input:
// 2
// 16
// 0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
// 6
// 5 8 3 7 9 1

// Output:
// 6
// 3


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	   BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	   int t = Integer.parseInt(r.readLine());
	   while (t-- > 0) {
	       int n = Integer.parseInt(r.readLine());
	       String[] s = r.readLine().trim().split("\\s+");
	       int[] A = new int[n];
	       for (int i = 0; i < n; ++i) {
	           A[i] = Integer.parseInt(s[i]);
	       }
	       int[] dp = new int[n];
	       dp[0] = 1;
	       int max = 1;
	       for (int i = 1; i < n; ++i) {
	           int val = 1;
	           for (int j = i - 1; j >= 0 ; --j) {
	               if (A[j] < A[i]) {
	                  val = Math.max(val, dp[j] + 1); 
	               }
	               
	           }
	           max = Math.max(val, max);
	           dp[i] = val;
	       }
	       System.out.println(max);
	   }
	 }
}