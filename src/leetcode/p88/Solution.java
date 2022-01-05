package leetcode.p88;

public class Solution {

    private static int[] sorted;

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        sorted = new int[m + n];
        sort(nums1, 0, nums1.length - 1);
    }

    private void sort(int[] nums1, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(nums1, start, mid);
            sort(nums1, mid + 1, end);
            merge(nums1, start, mid, end);
        }
    }

    private void merge(int[] nums1, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (nums1[i] < nums1[j]) {
                sorted[k] = nums1[i];
                i++;
            } else {
                sorted[k] = nums1[j];
                j++;
            }
            k++;
        }

        if (i <= mid) {
            for (int t = i; t <= mid; t++) {
                sorted[k] = nums1[t];
                k++;
            }
        } else {
            for (int t = j; t <= end; t++) {
                sorted[k] = nums1[t];
                k++;
            }
        }

        for (int t = start; t <= end; t++) {
            nums1[t] = sorted[t];
        }
    }
}
