class Solution {

    public String solution(String s, String skip, int index) {

        final int[] dict = new int[26];

        int bit = 0;
        for (final char c: skip.toCharArray()) bit |= (1 << (c - 97));

        for (int i=0, l=i+index; i<26; dict[i]=l%26, l=++i+index)
        for (int j=i; j<=l; j++)
        if ((bit & (1 << (j%26)))!=0) l++;

        return s
            .chars()
            .map(c -> dict[c-97]+97)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
