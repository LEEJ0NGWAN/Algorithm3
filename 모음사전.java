class Solution {

    private static final char[] chars = "AEIOU".toCharArray();
    private static int dfs(StringBuilder sb, String target, int index) {

        final int l = sb.length();
        if (l==target.length()) {

            boolean equals = true;
            for (int i=0; i<l; i++)
            if (!(equals&=sb.charAt(i)==target.charAt(i))) break;
            if (equals) return index;
        }
        if (l<chars.length)
        for (char c: chars) {

            sb.append(c);
            final int result = dfs(sb, target, ++index);
            if (result>0) return result;
            else index = -result;
            sb.setLength(l);
        }
        return -index;
    }

    public int solution(String word) {

        return dfs(new StringBuilder(), word, 0);
    }
}
