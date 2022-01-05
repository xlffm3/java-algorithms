package leetcode.p28;

public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        for (int i = 0; i < haystackArray.length; i++) {
            if (haystackArray[i] == needleArray[0]) {
                boolean flag = true;
                int tmpIndex = i;

                for (int j = 0; j < needleArray.length; j++) {
                    if (i == haystackArray.length || haystackArray[i] != needleArray[j]) {
                        flag = false;
                        break;
                    }
                    i++;
                }
                if (flag) {
                    return tmpIndex;
                }
                i = tmpIndex;
            }
        }

        return -1;
    }
}
