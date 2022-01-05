package leetcode.p9;

public class Solution {

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        int mid = length / 2;

        for (int i = 0; i < mid; i++) {
            char head = str.charAt(i);
            char tail = str.charAt(length - i - 1);

            if (head != tail) {
                return false;
            }
        }

        return true;
    }
}
