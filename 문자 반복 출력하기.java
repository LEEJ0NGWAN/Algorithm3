class Solution {
    
    public String solution(String my_string, int n) {

        return my_string
            .chars()
            .mapToObj(c -> {

                final char[] chars = new char[n];
                java.util.Arrays.fill(chars, (char)c);

                return chars;
            })
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
    }
}
