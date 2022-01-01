package leetcode.p1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
    Brute Force
    Time : O(n^2)
    Space : O(1)
    */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int first = nums[i];

            for (int j = i + 1; j < length; j++) {
                int second = nums[j];
                int sum = first + second;

                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    /*
    Improvement
    Time : O(n)
    Space : O(n)
    */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> indexByNumber = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int complement = target - number;

            if (indexByNumber.containsKey(complement)) {
                return new int[]{indexByNumber.get(complement), i};
            }

            indexByNumber.put(number, i);
        }

        return new int[]{};
    }
}
