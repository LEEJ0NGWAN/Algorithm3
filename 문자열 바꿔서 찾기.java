class Solution {

    public int solution(String myString, String pat) {
        
        return java.util.Optional
            .of(pat)
            .map(str-> pat
                .chars()
                .map(c-> 'A'+'B'-c)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString())
            .filter(myString::contains)
            .map(str-> 1)
            .orElse(0);
    }
}
