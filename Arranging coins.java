/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.
*/

class Solution {
    public int arrangeCoins(int n) {
        
      if(n==0) return 0;
        
        long left = 1, right = n/2+1;
        while(left < right){
            long mid = left + (right - left) / 2;
            long value = (mid + 1) * mid / 2;
            if(value == n){
                return (int)mid;
            }else if(value < n){
                left = mid + 1;
            }else if(value > n){
                right = mid - 1;
            }
        }
        return (int)((left+1)*left/2<=n?left:left-1);
    }
}
