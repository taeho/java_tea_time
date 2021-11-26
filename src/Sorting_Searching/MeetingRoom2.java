package Sorting_Searching;

/*
*
* https://leetcode.com/problems/meeting-rooms-ii/
*
*  1. 먼저 정렬
*  2. 겹치는 시간을 인지하고(앞의 회의시간 종료시간 염두)
*  3. 우선순위큐를 이용해서 회의 끝시간이 제일 긴것을 관리.
*    앞의 end 뒷start 시간을 비교해서 회의실 추가 필요없는것은 하나로 합치기
*     추가가 필요한 것은 큐 사용
*  4. min heap을 만든다.
*   Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
*
*
* */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {

    public static void main(String[] args) {
        MeetingRoom2 a = new MeetingRoom2();
        //int[][] intervals = { {5, 10}, {16, 20}, {0, 30}};
        int[][] intervals = { {5, 10}, {15, 20}, {0, 30}};
        //int[][] intervals = { {7, 10}, {2, 4}};
        System.out.println(a.solve(intervals));

    }

    public int solve(int[][] intervals) {
        //1.
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);  // asc 오름차순
        Queue<int []> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);   // end time 오름차순으로 관리

        //2. for pri qu
        for(int[] arr : intervals) {
            if(pq.isEmpty()) {
                pq.offer(arr);
            }
            else {
                if(pq.peek()[1] <= arr[0]) {
                    // 10 =< 16
                    pq.poll();
                }
                pq.offer(arr); // 0, 30   5,10
            }
        }
        return pq.size();
    }
}
