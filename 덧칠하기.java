class Solution {

    public int solution(int n, int m, int[] section) {

        n = 0;

        for (int i=0, l=0; i<section.length; i++)
        if (l<section[i]) { n++; l = section[i]+m-1; }

        return n;
    }
}
