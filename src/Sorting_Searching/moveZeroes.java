package Sorting_Searching;

/*
* https://leetcode.com/problems/move-zeroes/
*
* Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
*
* tip
* 값이 0이 아닌 값을 array에 담는다.
* index를 기억한다.
* 해당 index에 0인 값을 넣는다.
*
* */

public class moveZeroes {
    public static void main(String args[]){

        int[] nums = {0, 3, 2, 0, 8, 5};

        // 2. for
        // array + 0 index
        int n = nums.length;    // 6개
        int index = 0;

        for(int i=0; i <n; i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while(index < n ) {
            nums[index] = 0;
            index++;
        }

        //for(int i: nums) {
        //    System.out.print("i " + i);
        //}
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
