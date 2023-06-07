class Solution {
    
    private static void update(int x, int n, int[] dp) {

        if (x+n<dp.length) dp[x+n] = dp[x+n]==0? dp[x]+1: Math.min(dp[x]+1, dp[x+n]);
    }

    public int solution(int x, int y, int n) {

        if (x==y) return 0;
        final int[] dp = new int[y+1];

        update(x,n,dp); update(x,x,dp); update(x,x+x,dp);

        for (int i=x+1; i<y; i++)
        if (dp[i]!=0) { update(i,n,dp); update(i,i,dp); update(i,i+i,dp); }

        return dp[y]==0? -1: dp[y];
    }
}
