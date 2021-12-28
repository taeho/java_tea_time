package Array;

import java.util.Stack;

/*
*  https://leetcode.com/problems/daily-temperatures/
*
*  일일 온도가 int[] 배열로 주어지면
*  더 따뜻한 날씨의 날짜를 얻기위해 , 해당 날짜 이후에
*  기다려야하는 날짜의 수를 배열로 리턴.
*
*  더 따뜻한 날이 오지 않으면 0을 리턴.

* Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
*  73은 1일후 74,
*  74는 1일후 75
*  75 입장에서는 4일 후에 76이 된다.
*  71에서는 2일 후 72
*  69는 1일 후 72
*  72에서는 1일후 76이 된다.
*  76, 73은 그 이후 높은 날짜(따스한)없으므로 0
*
*
*
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
*
* */

public class DailyTemperature {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        //int[] res = solve_0(nums);
        int[] res = solve_stack(nums);
        //int[] res = solve_1(nums);
        System.out.println("====result====");
        for(int i : res) {
            System.out.print(i + " ");
        }

    }
    // for 문 2번 수행하기
    public static int[] solve_1(int[] temp) {

        // ds
        int len = temp.length;
        int[] result = new int[len];
        int count = 0, j;

        // for
        for(int i=0; i < len; i++) {
            for(j=i+1; j<len-1; j++) {
                if(temp[i] < temp[j]) {
                    count++;
                    break;
                } else {
                    count++;
                }
            }
            if(j == temp.length)
                result[i] = 0;
            else
                result[i] = count;

            count = 0; // 초기화 , 안하면 누적됨.
        }
        return result;
    }

    public static int[] solve_stack(int[] temp) {
        // 1. ds
        int len = temp.length;
        int[] result = new int[len]; // 8
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<len; i++) {
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]){
                int index = stack.pop();
                result[index] = i - index; // 1-0
            }
            stack.push(i); //0
        }
        return result;
    }
}
