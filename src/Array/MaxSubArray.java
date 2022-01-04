package Array;

/*
* https://leetcode.com/problems/maximum-subarray/
*
*
* Given an integer array nums, find the contiguous subarray
*  (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.
*
*Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
* */

public class MaxSubArray {

    public static void main(String[] args) {
//		int[] nums = {  -30, -20,-10 };
//		int[] nums = { 10, 10, -3, 10, 10 };
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {

        int curMax = nums[0];
        int allMax = nums[0];

        for(int i=1; i< nums.length; i++) {
            //System.out.println("nums["+i+"] "+nums[i]+" nums["+i+"] "+"+curMax: "+(nums[i]+curMax));

            // 부분에 대한 max, 
            // 누적 or 새로운값
            // 둘중에 큰값을 curMax에 저장.
            curMax = Math.max(nums[i], nums[i]+curMax);
            
            // 전체에 대한 max 값
            // 둘중에 큰값을 allMax에 저장.
            allMax = Math.max(allMax, curMax);

            //System.out.println("curMax: "+curMax+" allMax: "+allMax);
            //System.out.println("  ");
        }
        return allMax;
    }
}
