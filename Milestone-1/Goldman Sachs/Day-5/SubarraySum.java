Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).



class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int i, sum = 0;
        while(left<=right && right<nums.length && left >=0)
        {
            sum = 0;
            for(i = left; i<=right; i++)
                sum = sum + nums[i];
            if(sum >= target)
            {
                if(right-left<ans)
                    ans = right-left;
                left = left+1;
            }
            else if(sum<target)
            {
                right = right + 1;
            }
        }
        if(ans == Integer.MAX_VALUE)
            return 0;
        return ans+1;
    }
}