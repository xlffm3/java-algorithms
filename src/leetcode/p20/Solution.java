package leetcode.p20;

import java.util.ArrayDeque;

import java.util.*;

public class Solution {

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                deque.push(current);
                continue;
            } else {
                if (deque.isEmpty()) {
                    return false;
                }

                char target = deque.pop();
                if (!((current == ')' && target == '(') || (current == ']' && target == '[') || (current == '}' && target =='{'))) {
                    return false;
                }
            }

        }

        return deque.isEmpty();
    }
}
