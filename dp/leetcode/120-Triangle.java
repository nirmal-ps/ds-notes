// 120. Triangle


// Share
// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle

// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:

// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        
        if (m == 0) { 
          return 0;
        }
        for (int i = m - 2;i >= 0; --i  ) {
          List<Integer> el = triangle.get(i);  
          for(int j = 0; j < el.size(); ++j) {
              int lSum = j + 1 < triangle.get(i + 1).size() ?  
                  triangle.get(i + 1).get(j + 1) + el.get(j) : Integer.MAX_VALUE;
              int rSum = triangle.get(i + 1).get(j) + el.get(j);
              el.set(j, Math.min(lSum , rSum));
          }  
            
        }
        return triangle.get(0).get(0);
    }
}