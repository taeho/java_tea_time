package Array;

/*
* https://leetcode.com/problems/trapping-rain-water/
* Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by
* array [0,1,0,2,1,0,1,3,2,1,2,1].
* In this case, 6 units of rain water (blue section) are being trapped.
*
*  Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*
* */


public class TrappingRainWater {

    public static void main(String[] args) {

        int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(nums));
    }

    public static int trap(int[] height) {
        int result = 0;
        if(height == null || height.length <=2 ) {
            return result;
        }

        // 1. left 왼쪽에서 부터 max값을 구해서 배열에 담는다.
        int len = height.length; // 12 , 개수 12개니까.
        int[] left = new int[len];
        int[] right = new int[len];

        int max = height[0]; // 최초로 0번방부터 시작한다.
        left[0] = height[0];

        for(int i=1; i<len; i++ ) {
            if(height[i] < max ) {
                left[i] = max;
            } else {
                left[i] = height[i]; // 7번째 배열에 3이 큰값이 나온경우
                max = height[i];

            }
        }

        // 2. right 오른쪽에서 부터 max값을 구해서 배열에 담는다.
        max = height[len-1]; // 최초로 배열의 맨마지막 번방부터 시작한다.
        right[len-1] = height[len-1];

        for(int i=len-2; i>=0; i-- ) {  // 배열의 맨끝부터 시작햇으니 그 직전부터 비교역순시작
            if(height[i] < max ) {
                right[i] = max;
            } else {
                right[i] = height[i]; // 7번째 배열에 3이 큰값이 나온경우
                max = height[i];

            }
        }
        // 3. left와 right배열에서 각각의 0부터 index를 비교해서 최솟값을 구한다.
        // 4. 그리고 높이를 구하고 나서
        // 5. 최솟값에서 그 높이를 빼준다. min() - height
        for(int i=0; i<len; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
