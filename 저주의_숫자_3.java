class Solution {

    private static final int MAX = 100;
    private static final int[] arr = new int[MAX+1];

    static {

        for(int i=1, n=1; i<=MAX; ++i, ++n)
        if (n%3==0 || String.valueOf(n).contains("3")) --i;
        else arr[i] = n;
    }

    public int solution(int n) { return arr[n]; }
}
