package Sorting_Searching;

/*
*
* https://leetcode.com/problems/merge-intervals/
*
* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*
* IDEA
*
*    { 1, 4 },  { 8, 10 }, { 2, 6 }, { 15, 18 }
*
*  겹치는 부분을 합친다. [1,4], [2,6] 이면
*   [1,4] 에서 4와 [2,6]에서 2를 비교해서 합친다. 그러면 [1,6]을 만든다.
*
*   [1,6]과 [8,10]을 비교해서 [8,10]을 리스트에 결과 저장한다.
*   즉, 전의.end 6 < 현재.start 8을 비교한 내용 도출
*
*   1) 4>= 2 이면, 1-6으로 만든다.
*    전의.end > 현재.start
*    end = Math.max(전의.end, 현재.end)
*    새로운 1,6을 만든다.
*    start=1, end=6을 넣어서 다음 (8,10)을 비교한다.
*
*   2) 다시 전의.end > 현재.start를 비교해서 , 6 >= 8이 아니므로
*   [8, 10]을 결과 값에 저장한다.
*   start=8, end=10을 넣어서 다음 [15, 18]을 비교한다.
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        MergeInterval a = new MergeInterval();
        int[][] intervals = {
                { 1, 4 },
                { 8, 10 },
                { 2, 6 },
                { 15, 18 }
        };
        int[][] res = a.solve(intervals);
        for (int[] arr : res) {
            System.out.println("result");
            System.out.println(arr[0] + ":" + arr[1]);
        }
    }

    public int[][] solve(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length ==0 || intervals == null)
            return res.toArray(new int[0][]);

        // data structure
        print(intervals);
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        System.out.println("==after==");
        print(intervals);

        // for while
        int start = intervals[0][0];
        int end = intervals[0][1];
        // start 는 1추출, end 는 4가 된다.
        for(int i = 1; i< intervals.length; i++) {
            // 현재 end와 다음 좌표의 시작start과 비교 해서
            if(end >= intervals[i][0]){
                // 현재 end가 크거나 같으면
                // 2, 6을 만나면 합쳐서 1,6으로 만들어준다.
                end = Math.max(end, intervals[i][1]);
            } else {    // 겹치지 않는경우
                // for 바로 직전의 조건을 갖고 저장한다.
                // 이렇게 저장해야 int[]배열에 저장.
                // 1, 6
                res.add(new int[]{start, end});
                // 8, 10을 저장.
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // 15, 18 마지막 for 나오기전
        // 끝에 잇던 조건 배열을 빼먹지 않고 저장.
        res.add(new int[] {start, end});

        // 2차원 int배열을 리턴해준다.
        return res.toArray(new int[res.size()][]);
    }


    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
