// In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

// For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

// Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

// Note:

// The given numbers of 0s and 1s will both not exceed 100
// The size of given string array won't exceed 600.
 

// Example 1:

// Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
// Output: 4

// Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 

// Example 2:

// Input: Array = {"10", "0", "1"}, m = 1, n = 1
// Output: 2

// Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

class Solution {
    public int findMaxForm(String[] A, int m, int n) {
        int len = A.length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m+1; ++i) {
            Arrays.fill(dp[i], 0);
        }
        
        for (String s : A) {
            int[] nums = cal(s);
            
            for (int i = m; i >= nums[0]; --i) {
                for (int j = n; j >= nums[1]; --j) {
                    if (i >= nums[0] && j >= nums[1]) {
                       dp[i][j] = Math.max(dp[i][j], 1 + dp[i - nums[0]][j - nums[1]]); 
                    } else {
                      dp[i][j] = dp[i - 1][j];
                    }
                    
                }
                
            }
            
        }
        return dp[m][n];
        
    }
    public int[] cal(String A) {
        int[] res = new int[]{0, 0};
        for (char ch : A.toCharArray() ) {
            if (ch == '0'){
               res[0] += 1; 
            }
            else if (ch == '1') {
                res[1] += 1;
            }
        }
        return res;
    }
}