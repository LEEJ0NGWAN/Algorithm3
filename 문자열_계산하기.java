class Solution {

    public int solution(String my_string) {

        int answer = 0;

        final StringBuilder sb = new StringBuilder();

        for (final char c: my_string.toCharArray())

        if (Character.isDigit(c) || c == '-') sb.append(c);
        else if (
            Character.isWhitespace(c) &&
            ((sb.length()> 1 && sb.charAt(0)=='-') ||
             (sb.length()>=1 && sb.charAt(0)!='-') ))
        sb.setLength((answer += Integer.parseInt(sb.toString())) & 0);

        return answer += Integer.parseInt(sb.toString());
    }
}
