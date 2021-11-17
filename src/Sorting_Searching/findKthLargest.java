package Sorting_Searching;

/*
* https://leetcode.com/problems/kth-largest-element-in-an-array/
*
*Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
*
*
* */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class findKthLargest {

    public static void main(String args[]) {
        findKthLargest a = new findKthLargest();
        int[] nums = { 2, 3, 1, 5, 6, 4};
        int k = 2;

        System.out.println(a.solve(nums, k));
        System.out.println(a.solve_pq(nums,k));
    }

    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length; // 6개
        return nums[n-k]; // 1, 2, 3, 4, 5, 6 - 4번방을 찾는다.
    }

    public int solve_pq(int[] nums, int k) {
        //ds
        Queue<Integer> pq = new PriorityQueue<>(); // default- asc min heap

        // for
        for(int i : nums) {
            pq.offer(i);
            if(pq.size() > k ) {    // k개 만큼만 실행 nlogk
                pq.poll();
            }
        }
        return pq.peek();
    }

}
