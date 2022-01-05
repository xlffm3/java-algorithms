package leetcode.p14;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        StringBuilder sb = new StringBuilder();
        int shortestStringLength = strs[0].length();

        for (int i = 0; i < shortestStringLength; i++) {
            int index = i;
            long distinctCharacterCount = Arrays.stream(strs)
                .map(str -> str.charAt(index))
                .distinct()
                .count();

            if (distinctCharacterCount == 1) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
