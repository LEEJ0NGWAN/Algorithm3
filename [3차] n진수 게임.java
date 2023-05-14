class Solution {

    public String solution(int n, int t, int m, int p) {

        final StringBuilder sb = new StringBuilder();

        int number = 0, next = 0; --p;

        while (t>0) {

            final String s = Integer.toString(number++, n);
            for (int i=0,l=s.length(); i<l&&t>0; i++, next=++next%m)
            if (next==p) { sb.append(s.charAt(i)); --t; }
        }

        return sb.toString().toUpperCase();
    }
}
