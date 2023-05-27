class Solution {

    public String solution(String code) {

        final StringBuilder sb = new StringBuilder();

        int mode = 0;
        for (int i=0,l=code.length(); i<l; i++)
        if (code.charAt(i)=='1') mode = 1-mode;
        else if (i%2==mode) sb.append(code.charAt(i));

        return (code=sb.toString()).isEmpty()? "EMPTY": code;
    }
}
