class Solution {

    public String solution(String my_string) {

        return my_string
            .chars()
            .filter(c -> c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u')
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
