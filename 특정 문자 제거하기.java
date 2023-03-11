class Solution {

    public String solution(String my_string, String letter) {

        return my_string
            .chars()
            .filter(c -> c!=letter.charAt(0))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
