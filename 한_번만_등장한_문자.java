class Solution {

    public String solution(String s) {

        return s
            .chars()
            .sorted()
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString()
            .replaceAll("([a-z])\\1+", "");
    }
}
