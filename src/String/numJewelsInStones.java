package String;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/jewels-and-stones
 *
 * Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0


Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
*
 *
 *
 * hint
 * 보석은 대소문자 구분해서 갖고잇어야한다
 * aA ->> 2개
 * 보석저장은 set 사용
 * Stones를 for 문 루프 사용
 * Set에 있는 값과 비교해서 count
 *
 *  */

public class numJewelsInStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(solve(J, S));
    }

    public static int solve(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            set.add(jewel); // a, A
        }

        int count = 0;
        for (char stoneChar : stones.toCharArray()) {
            System.out.println("stoneChar: " + stoneChar);
            if (set.contains(stoneChar)) {
                count++;
            }
        }
        return count;
    }
}
