class Solution {

    public String solution(int age) {

        return String
            .valueOf(age)
            .chars()
            .map(x -> x+49)
            .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append)
            .toString();
    }
}
