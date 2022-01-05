package leetcode.p13;

public class Solution {

    public int romanToInt(String s) {
        int length = s.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            Roman roman = Roman.valueOf(String.valueOf(current));
            int value;

            if (roman == Roman.I || roman == Roman.X || roman == Roman.C) {
                if (i + 1 < length) {
                    char next = s.charAt(i + 1);
                    Roman nextRoman = Roman.valueOf(String.valueOf(next));
                    value = roman.parse(nextRoman);

                    if (value != roman.getValue()) {
                        i++;
                    }
                } else {
                    value = roman.getValue();
                }
            } else {
                value = roman.getValue();
            }

            sum += value;
        }

        return sum;
    }

    private static enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private final int value;

        Roman(int value) {
            this.value = value;
        }

        public int parse(Roman roman) {
            if (this == Roman.I && (roman == Roman.V || roman == Roman.X)) {
                return roman.value - this.value;
            }
            if (this == Roman.X && (roman == Roman.L || roman == Roman.C)) {
                return roman.value - this.value;
            }
            if (this == Roman.C && (roman == Roman.D || roman == Roman.M)) {
                return roman.value - this.value;
            }

            return this.value;
        }

        public int getValue() {
            return value;
        }
    }
}
