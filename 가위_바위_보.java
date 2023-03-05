class Solution {

    public String solution(String rsp) {

        return rsp
            .chars()
            .map(c -> c=='0'? '5': c=='2'? '0': '2')
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
