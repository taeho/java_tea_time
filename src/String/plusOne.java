package String;

/*
*  https://leetcode.com/problems/plus-one/
*
* Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [0]
Output: [1]
Explanation: The array represents the integer 0.
Incrementing by one gives 0 + 1 = 1.
Thus, the result should be [1].
Example 4:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
*
* */

public class plusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
//		int[] digits = {9,9,9};
//		int[] digits = {9,8,9};
//		int[] digits = {8,9,9};
//		int[] digits = {0,0,1};
//		int[] digits = {0,0};
//		int[] digits = {9,0,0,9};
//		int[] digits = {9,9,9,9,9};


        int[] result = solve(digits);
        for (int i : result)
            System.out.println("val: " + i);
    }

    public static int[] solve(int[] digits) {

        // 배열의 크기 구한다.
        int n = digits.length;

        // 길이의 맨 끝부터 시작
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;

            // 10 이하는 carry 신경안써도 된다.
            if (digits[i] < 10) {
                return digits;
            }

            // 
            digits[i] = 0;
        }

        // carry 가 발생하면 길이를 늘린다. 새로 선언
        int[] res = new int[n + 1];
        res[0] = 1;

        return res;
    }
}
