class Solution {

    private static final int mod = 1234567;
    private static final int count = 100000;
    private static final int[] arr = new int[count+1];

    static {

        arr[1] = 1;
        for (int i=2; i<=count; arr[i]=arr[i-1]%mod+arr[i++-2]%mod);
    }

    public int solution(int n) {

        return arr[n]%mod;
    }
}
