package leetcode.p2;

import java.util.Objects;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode startNode = node;
        int upperCounter = 0;

        while (l1 != null || l2 != null) {
            int sum = calculateSum(l1, l2) + upperCounter;
            upperCounter = sum / 10;
            int val = sum % 10;

            l1 = Objects.isNull(l1) ? null : l1.next;
            l2 = Objects.isNull(l2) ? null : l2.next;

            node.next = new ListNode(val);
            node = node.next;
        }

        if (upperCounter != 0) {
            node.next = new ListNode(1);
        }

        return startNode.next;
    }

    private int calculateSum(ListNode l1, ListNode l2) {
        int val1 = Objects.isNull(l1) ? 0 : l1.val;
        int val2 = Objects.isNull(l2) ? 0 : l2.val;
        return val1 + val2;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
