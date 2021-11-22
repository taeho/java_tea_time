package Sorting_Searching;

/*
* https://leetcode.com/problems/meeting-rooms-ii/
* https://www.lintcode.com/en/old/problem/meeting-rooms-ii/
*
*
* 전미팅.end > 현재미팅.start
* 이차원 배열 사용
* 첫번째 배열을 빼서, 두번째부터 비교
* end = intervals[0][1]
*
*
*
* */

import java.lang.reflect.Array;
import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {
        MeetingRoom a = new MeetingRoom();
        // 결과는 false가 된다
        int[][] intervals = {{5,10}, {16,20}, {0,30}};

        // 결과는 true 가 된다.
        // [비교자리수 기준][]  의 배열에서 정렬 sort 시
        // {2,4}, {7,10}이 되는데
        // 0번방의 4번 end가 1번방의 7에 영향을 끼치지 않으므로
        //int[][] intervals = {{7, 10}, {2,4}};

        System.out.println(a.solve(intervals));

    }

    public boolean solve(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return true;
        }

        // 1. sorting 정렬, logn의 속도로
        print(intervals);
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);   // 오름차순 정렬
        // 2차원배열중 앞의 숫자로 정렬한다.
        System.out.println("==========");
        print(intervals);


        // 2. for
        int end = intervals[0][1]; // 0, 30
        // 30 들어가있는데..
        // 5의 10을 비교
        for(int i=1; i< intervals.length; i++ ) {
            // 5, 10
            // 최초 5를 말한다.
            if(intervals[i][0] < end) {
                // 즉 시작시간보다 전 미팅의 끝나는 시간보다 끝나면 사용불가
                return false;
            }
            // for문 상태에서 intervals[1][1]의 end time은 5,10에서
            // 10을 말하는데, 이게 end로 대입
            //
            end = intervals[i][1];
        }
        return true;
    }

    private void print(int[][] grid) {
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j< grid[0].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
