package leetcode.p27;

import java.util.Arrays;

public class Solution {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int i = 0;
        int valCount = 0;
        while (i < nums.length && nums[i] != val) {
            i++;
        }

        int start = i;

        while (i < nums.length && nums[i] == val) {
            i++;
            valCount++;
        }

        int end = i;

        for (int j = end; j < nums.length; j++) {
            nums[start] = nums[j];
            start++;
        }
        return nums.length - valCount;
    }
}
