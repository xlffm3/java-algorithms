package leetcode.p53;

public class Solution {

    public int maxSubArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return divideAndSumMax(nums, start, end);
    }

    private int divideAndSumMax(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = (start + end) / 2;
        int leftSum = divideAndSumMax(nums, start, mid);
        int rightSum = divideAndSumMax(nums, mid + 1, end);
        int crossSum = divideAndSumMaxCross(nums, start, mid, end);

        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    private int divideAndSumMaxCross(int[] nums, int start, int mid, int end) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = mid; i >= start; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        sum = 0;
        for (int i = mid + 1; i <= end; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax + rightMax;
    }
}
