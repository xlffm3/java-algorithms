package leetcode.p100;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return validateSameness(p, q);
    }

    private boolean validateSameness(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p != null && q != null) {
            boolean isSameValue = p.val == q.val;
            if (!isSameValue) {
                return false;
            }
            boolean checkLeft = validateSameness(p.left, q.left);
            boolean checkRight = validateSameness(p.right, q.right);

            if (!checkLeft || !checkRight) {
                return false;
            }
        }
        return true;
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
