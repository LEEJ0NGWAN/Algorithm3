class Solution {

    private static final int mod = 1234567;
    private static final int size = 2000;
    private static final int[] arr = new int[size+1];

    static {

        arr[1] = 1; arr[2] = 2;
        for (int i=3; i<=size; arr[i] = arr[i-2]%mod+arr[i++-1]%mod);
    }

    public int solution(int n) { return arr[n]%mod; }
}
