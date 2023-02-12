class Solution {

    public String solution(String my_string) {

        return my_string
            .chars()
            .map(Character::toLowerCase)
            .sorted()
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
