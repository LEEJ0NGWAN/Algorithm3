class Solution {
    
    public boolean solution(String s) {        

        return java.util.regex.Pattern
            .compile("^\\d{4}$|^\\d{6}$")
            .matcher(s)
            .find();
    }
}
