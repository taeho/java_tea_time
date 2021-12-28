package Array;

/*
*
* https://leetcode.com/problems/two-sum/
*
* Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*
* */

import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public static void main(String[] args) {

        twoSum a = new twoSum();
        int[] nums = {2, 8, 11, 14};
        int target = 16;
        int[] result = a.solve(nums, target);
        //int[] result = a.solve_for(nums, target);
        for(int i: result) {
            System.out.println(i + " ");
        }
    }

    // O(n^2)
    public int[] solve_for(int[] nums, int target) {

        int len = nums.length;

        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i+1, j+1};
                }
            }
        }
        return new int[] {0, 0};

    }

    // O(n)
    public int[] solve(int[] nums, int target) {

        // 1. ds
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        // 2. for
        for(int i=0; i< nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                result[0] = val + 1;
                result[1] = i+1;
            } else {
                map.put(target-nums[i], i);
            }
        }
        return result;
    }
}
