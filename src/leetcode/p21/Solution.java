package leetcode.p21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> mergedList = new ArrayList<>();
        append(mergedList, list1);
        append(mergedList, list2);
        Collections.sort(mergedList);

        ListNode head = new ListNode(0);
        ListNode tmp = head;

        for (Integer integer : mergedList) {
            ListNode node = new ListNode(integer);
            tmp.next = node;
            tmp = node;
        }

        return head.next;
    }

    private void append(List<Integer> mergedList, ListNode list) {
        while (Objects.nonNull(list)) {
            mergedList.add(list.val);
            list = list.next;
        }
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
