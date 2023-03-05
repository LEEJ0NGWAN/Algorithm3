class Solution {

    public String solution(String my_string) {

        return my_string
            .chars()
            .map(c -> c + 32*(Character.isUpperCase(c)? 1: -1))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
