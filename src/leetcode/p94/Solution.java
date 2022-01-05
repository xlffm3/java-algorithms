package leetcode.p94;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> route = new ArrayList<>();
        if (Objects.isNull(root)) {
            return route;
        }

        traverse(root, route);
        return route;
    }

    private void traverse(TreeNode root, List<Integer> route) {
        if (root != null) {
            if (root.left != null) {
                traverse(root.left, route);
            }
            route.add(root.val);
            if (root.right != null) {
                traverse(root.right, route);
            }
        }
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
