/* PROBLEM STATEMENT
A string is defined to be "strictly smaller" than another string when the number of occurrences of the lexicographically smallest character in the string is less than that of the other. For example, "abcd" is strictly smaller than "aaa" because the smallest character in "abcd", "a", appears 1 time, whereas the smallest character in "aaa", "a", appears 3 times. In another example, "d" is strictly smaller than "ff" because the smallest character in "d", 'd', appears 1 time, and the smallest character in "ff", 'f', appears 2 times.

Given a list of strings str1 with m elements, and another list of strings str2 with n elements, return an array A of n integers. For 0 <= i < n, A[i] is the number of strings in str1 that are strictly smaller than the comparison i-th string in str2. Focus on correctness instead of performance in your solution.

Input
str1: a list of strings with m elements.
str2: a list of strings with n elements.
Output:
An integer array of size n

Examples:
Input: str1 = "abcd aabc bd"    str2 = "aaa aa"
Output: [3, 2]

Explanation:
All the strings in str1 are strictly smaller than "aaa", and strings "abcd" and "bd" are strictly smaller than "aa".

Constraints
1 <= n, m <= 10000
1 <= length of any string in str1 or str2 <= 10
All the input strings are made up of lowercase English alphabets (a-z)
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareStrings {
    public List<Integer> compareStrings(List<String> str1, List<String> str2) {
        List<Integer> result = new ArrayList<>();

        for(String str: str2){
            int count = countStringsLessThan(str1, str);
            result.add(count);
        }
        return result;
    }

    private int countStringsLessThan(List<String> str1, String str) {
        int strCount = lexCount(str);
        int count = 0;
        for(String s: str1){
            int sCount = lexCount(s);
            if(sCount < strCount){
                count++;
            }
        }
        return count;
    }

    private Integer lexCount(String s){
        Character minChar = Character.MAX_VALUE;
        int count = 0;
        for(Character c: s.toCharArray()){
            if(c < minChar){
                minChar = c;
                count = 1;
            } else if(c == minChar){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CompareStrings obj = new CompareStrings();
        System.out.println(obj.compareStrings(Arrays.asList("abcd", "aabc", "bd"), Arrays.asList("aaa", "aa")));
    }
}
