class Solution {

    public String solution(String s) {

        return java.util.stream.IntStream
            .range(0, s.length())
            .map(x -> x==0||s.charAt(x-1)==' '? Character.toUpperCase(s.charAt(x)): Character.toLowerCase(s.charAt(x)))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
