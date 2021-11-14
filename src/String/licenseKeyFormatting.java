package String;

/*
* https://leetcode.com/problems/license-key-formatting/
*
*Example 1:

Input: s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"
Explanation: The string s has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:

Input: s = "2-5g-3-J", k = 2
Output: "2-5G-3J"
Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.


Constraints:

1 <= s.length <= 105
s consists of English letters, digits, and dashes '-'.
1 <= k <= 104
*
* '-' 를 없애기 replace
* 대문자 만들기 toUpperCase()
* k=4문자열 나누기
* 나눈 문자열에 '-' 대쉬 넣기
* */
public class licenseKeyFormatting {
    public static void main(String[] args) {
        String str = "8F3Z-2e-9-wabcdef";
//		String str = "8F3Z-2e-9-w";
//		String str = "8-5g-3-J";
        int k =4;
        System.out.println(solve(str, k));
    }

    public static String solve(String str, int k ) {

        //1. - del
        String newStr= str.replace("-", "");
        System.out.println("1: "+newStr);

        //2. upper
        newStr= newStr.toUpperCase();
        System.out.println("2: "+newStr);

        //3. k개로 파싱하기, 그리고 - 넣기
        StringBuilder sb = new StringBuilder(newStr);
        System.out.println("3: "+newStr);
//		"8F3Z2E9W"
        int len = sb.length();
        for(int i=k; i<len; i=i+k) {
            System.out.println("len-i: "+(len-i));
            sb.insert(len-i, '-');
            System.out.println("4: "+sb);
        }
        return sb.toString();

    }
}
