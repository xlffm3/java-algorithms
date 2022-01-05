package leetcode.p67;

public class Solution {

    public String addBinary(String a, String b) {
        char[] first = a.toCharArray();
        char[] last = b.toCharArray();
        int firstIndex = first.length - 1;
        int lastIndex = last.length - 1;
        StringBuilder sb = new StringBuilder();

        int surplus = 0;
        while (firstIndex >= 0 || lastIndex >= 0) {
            int firstBinary = firstIndex >= 0 ? first[firstIndex] - '0' : 0;
            int lastBinary = lastIndex >= 0 ? last[lastIndex] - '0' : 0;

            int sum = firstBinary + lastBinary + surplus;
            surplus = sum / 2;
            sum = sum % 2;
            sb.append(sum);

            firstIndex--;
            lastIndex--;
        }
        if (surplus != 0) {
            sb.append(1);
        }

        sb.reverse();
        return sb.toString();
    }
}
