package leetcode.p66;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int[] plusOne(int[] digits) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int digit : digits) {
            deque.push(digit);
        }

        int surplus = 1;
        for (int i = 0; i < digits.length; i++) {
            int number = deque.pop();
            number += surplus;
            surplus = 0;
            if (number >= 10) {
                number -= 10;
                surplus = 1;
            }
            deque.addLast(number);
        }
        if (surplus == 1) {
            deque.addLast(1);
        }

        int[] answer = new int[deque.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deque.pollLast();
        }

        return answer;
    }
}
