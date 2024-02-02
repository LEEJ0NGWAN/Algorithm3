class Solution {

    public String solution(String rny_string) {

        return rny_string
            .chars()
            .collect(StringBuilder::new, (sb, c)-> sb.append('m'==c? "rn": (char)c), (a,b)-> {})
            .toString();
    }
}
