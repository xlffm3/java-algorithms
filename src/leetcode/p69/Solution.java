package leetcode.p69;

public class Solution {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long low = 0;
        long high = x / 2;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sqrt = mid * mid;

            if (sqrt == x) {
                return (int) mid;
            } else if (sqrt < x) {
                low = mid + 1;
            } else if (sqrt > x) {
                high = mid - 1;
            }
        }

        return (int) high;
    }
}
