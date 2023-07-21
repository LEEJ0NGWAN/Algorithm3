class Solution {

    private static int foo(char c) {
        return c=='('? 1:-1;
    }
    private static char reverse(char c) {
        return '('==c? ')':'(';
    }
    public String solution(String p) {

        if (p.isEmpty()) return p;

        int tmp = foo(p.charAt(0));
        boolean valid = tmp>0;
        for (int i=1; i<p.length(); i++)
        if ((tmp+=foo(p.charAt(i)))<0) { valid = false; }
        else if (tmp==0) { tmp = i+1; break; }

        final String v = p.substring(tmp);
        if (valid)
        return p.substring(0,tmp)+solution(v);

        final StringBuilder sb = new StringBuilder();
        sb
            .append('(')
            .append(solution(v))
            .append(')');
        for (int i=1, l=tmp-1; i<l; sb.append(reverse(p.charAt(i++))));

        return sb.toString();
    }
}
