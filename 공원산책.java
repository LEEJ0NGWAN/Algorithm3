class Solution {

    public int[] solution(String[] park, String[] routes) {

        final int[] size = { park.length, park[0].length() };

        final int[] pos = new int[2];

        for (int i=0; i<size[0]; i++)
        for (int j=0; j<size[1]; j++)
        if  (park[i].charAt(j)=='S') {

            pos[0] = i; pos[1] = j;
            break;
        }

        for (final String route: routes) {

            final char op = route.charAt(0);

            final int sign = "ES".indexOf(op)|1;
            final int direction = "NSEW".indexOf(op)/2;

            final int n = (route.charAt(2)-'0') * sign;
            final int next = pos[direction]+n;

            if (0<=next && next<size[direction]) {

                final int[] test = { pos[0], pos[1] };
                for (int i=0,l=Math.abs(n); i<l; i++) {

                    test[direction] += sign;
                    if (park[test[0]].charAt(test[1])=='X') break;
                }

                if (park[test[0]].charAt(test[1])!='X')
                pos[direction] = test[direction];
            }
        }

        return pos;
    }
}
