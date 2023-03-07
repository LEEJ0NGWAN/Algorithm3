class Solution {

    public String solution(String cipher, int code) {

        final int[] index = new int[1];

        return cipher
            .chars()
            .filter(c -> ++index[0]%code==0)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
