package leetcode.p3;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /*
    DP 적용.
    1. i = 0 부터 시작.
    2. j = i + 1부터 시작.
    3. s[i] ~ s[j - 1] 부분 문자열이 s[j] 문자를 포함하는가?
    4. 포함한다면 현재 i에서의 가장 긴 부분 문자열은 s[i] ~ s[j - 1], i를 높여 재검사
    5. 아니라면 j++ 하며 검사 진행
    */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int stringLength = s.length();
        int answer = 1;

        for (int i = 0; i < stringLength; i++) {
            for (int j = i + 1; j < stringLength; j++) {
                String substr = s.substring(i, j);
                String target = String.valueOf(s.charAt(j));

                if (substr.contains(target)) {
                    break;
                }

                int nextSubstrLength = substr.length() + 1;
                if (nextSubstrLength > answer) {
                    answer = nextSubstrLength;
                }
            }
        }

        return answer;
    }

    /*
    Set을 이용
     */
    public int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (j < length) {
            if (i > j) {
                break;
            }

            char target = s.charAt(j);
            if (!set.contains(target)) {
                set.add(target);
                j++;
                maxLength = Math.max(maxLength, j - i);
                continue;
            }
            set.remove(s.charAt(i));
            i++;
        }

        return maxLength;
    }
}
