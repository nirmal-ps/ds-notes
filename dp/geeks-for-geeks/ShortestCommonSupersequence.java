// Given two strings str1 and str2, find the length of the smallest string which has both, str1 and str2 as its sub-sequences.
// Note: str1 and str2 can have both uppercase and lowercase letters.

// Input:
// The first line of input contains an integer T denoting the number of test cases.Each test case contains two space separated strings.

// Output:
// For each testcase, in a new line, output the length of the required string.

// Constraints:
// 1 <= T <= 100
// 1<= |str1|, |str2| <= 100

// Example:
// Input:
// 2
// abcd xycd
// efgh jghi
// Output:
// 6
// 6

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
	        
	        String[] s = r.readLine().trim().split("\\s+");
	        
	        int m = s[0].length();
	        int n = s[1].length();
	        int[][] dp = new int[m + 1] [ n + 1];
	        for (int i = 0; i <= m ; ++i) {
	            for (int j = 0 ; j <= n; ++j ) {
	                if (i == 0 || j == 0 ) {
	                    dp[i][j] = 0;
	                    
	                } else {
	                    char a = s[0].charAt(i - 1);
	                    char b = s[1].charAt(j - 1 );
	                    if (a == b) {
	                        dp[i][j] = dp[i - 1][j - 1] + 1;
	                    } else {
	                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	                    }
	                }
	            }
	        }
	        System.out.println(m + n - dp[m][n]);
	    }
	 }
}