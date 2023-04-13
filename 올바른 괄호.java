class Solution {

    boolean solution(String s) {

        int count = 0;
        for (final char c: s.toCharArray())
        if ((count += c=='('? 1: -1) < 0) return false;

        return count==0;
    }
}
