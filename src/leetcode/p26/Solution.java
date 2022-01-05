package leetcode.p26;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxNumber = nums[nums.length - 1];
        int tmp = nums[0];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            while (tmp < maxNumber && tmp == nums[i]) {
                i++;
            }

            if (nums[index] == maxNumber) {
                break;
            }

            index++;
            nums[index] = nums[i];
            tmp = nums[i];
        }

        return index + 1;
    }
}
