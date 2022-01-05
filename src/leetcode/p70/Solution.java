package leetcode.p70;

public class Solution {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        long[] arr = new long[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return (int) arr[n];
    }
}
