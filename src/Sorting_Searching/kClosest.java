package Sorting_Searching;

/*
*  https://leetcode.com/problems/k-closest-points-to-origin/
*
* Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
*
* Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.


Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104
*
*
* */

import java.util.PriorityQueue;
import java.util.Queue;

public class kClosest {
    public static void main(String[] args) {
        kClosest a = new kClosest();
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int k = 1;

        // int[][] points = {{3,3},{5,-1},{-2,4}};
        // int k =2;

        int[][] result = a.solve(points, k);
        a.print(result);
    }

    public int[][] solve(int[][] points, int k) {

        // ds
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        int[][] result = new int[k][2];

        // for
        for(int[] p : points) {
            pq.offer(p);
        }

        int index = 0;
        while(index < k) {
            result[index] = pq.poll();
            index++;
        }
        return result;
    }

    public void print(int[][] result) {
        int m = result.length;
        int n = result[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" [" + i + "][" + j + "] " + result[i][j]);
            }
            System.out.println();
        }
    }
}
