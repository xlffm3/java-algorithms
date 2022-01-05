package leetcode.p35;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            int midNumber = nums[mid];

            if (target > midNumber) {
                low = mid + 1;
            } else if (target < midNumber) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return low;
    }
}
