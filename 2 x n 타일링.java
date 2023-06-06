class Solution {

    private static final int MAX = 1000000007;

    public int solution(int n) {

        final int[] dp = new int[n+1];

        dp[0] = dp[1] = 1;

        for (int i=2; i<=n; i++)
        dp[i] = (dp[i-2]%MAX+dp[i-1]%MAX)%MAX;

        return dp[n];
    }
}
