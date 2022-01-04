package Array;

/*
* https://leetcode.com/problems/group-anagrams/
*
*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
*  typically using all the original letters exactly once.
*
*Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*
*
* */


import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] list = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("re "+groupAnagrams2(list));
//		System.out.println(groupAnagrams_ascii(list));
    }

    // 키 값은 고유하게
    // for loop를 이용해서 한개의 string을 뺀 후 toCharArray를 이용해서 sort 하고나서
    // 키로 이용
    // sort 하는 방법
    public static List<List<String>> groupAnagrams(String[] strs) {
        // ds 선언
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return result;
        Map<String, List<String>> map = new HashMap<>();

        // for
        for(String str: strs) {
            char[] charArr = str.toCharArray(); // "eat"를 ['e', 'a', 't']로
            Arrays.sort(charArr);   // ['e', 'a', 't']를 ['a', 'e', 't']로

            // 스트링으로 전달.
            String key = String.valueOf(charArr);
            System.out.println("key " + key);

            // map에 해당 키를 저장
            if(map.containsKey(key)) {
                // 있으면, map에서 꺼내서
                // add string을 해준다.
                map.get(key).add(str);
            } else {
                //없으면 저장
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        result.addAll(map.values());
        return result;

        //return new ArrayList<>(map.values());
    }

    // 키 값은 고유하게
    // for loop를 이용해서 한개의 string을 뺀 후 toCharArray를 이용해서 sort 하고나서
    // 키로 이용
    // sort 하는 방법
    public static List<List<String>> groupAnagrams2(String[] strs) {
        // ds 선언
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return result;
        Map<String, List<String>> map = new HashMap<>();

        // for
        for(String str: strs) {
            char[] charArr = str.toCharArray(); // "eat"를 ['e', 'a', 't']로
            Arrays.sort(charArr);   // ['e', 'a', 't']를 ['a', 'e', 't']로

            // 스트링으로 전달.
            String key = String.valueOf(charArr);
            System.out.println("key " + key);

            // map에 해당 키를 저장
//            if(map.containsKey(key)) {
//                // 있으면, map에서 꺼내서
//                // add string을 해준다.
//                map.get(key).add(str);
//            } else {
//                //없으면 저장
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(key, list);
//            }

            // 위의 조건절을 아래의 getOrDefault 함수로 대체 가능.
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        result.addAll(map.values());
        return result;

        //return new ArrayList<>(map.values());
    }

    // Map을 이용해서 key, value로 넣는다.
    // sort를 안하는 방법
    public static List<List<String>> groupAnagrams_ascii(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        result.addAll(map.values());
        return result;
    }
}
