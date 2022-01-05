package leetcode.p58;

public class Solution {

    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        int i = length - 1;

        while (arr[i] == ' ') {
            i--;
        }

        int wordLength = 0;
        while (i >= 0 && arr[i] != ' ') {
            i--;
            wordLength++;
        }

        return wordLength;
    }
}
