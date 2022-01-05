package leetcode.p83;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode start = new ListNode(0);
        ListNode tmp = start;

        while (head != null) {
            int value = head.val;
            if (!set.contains(value)) {
                ListNode node = new ListNode(value);
                tmp.next = node;
                tmp = node;
                set.add(value);
            }
            head = head.next;
        }

        return start.next;
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
