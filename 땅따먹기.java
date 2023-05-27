class Solution {

    private static final int columnSize = 4;

    int solution(int[][] land) {

        final int[][] dp = new int[land.length][columnSize];
        for (int i=0; i<columnSize; dp[0][i] = land[0][i++]);

        for (int i=1; i<land.length; i++)
        for (int j=0; j<columnSize; j++)
        for (int k=0; k<columnSize; k++)
        if (j!=k)
        dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+land[i][j]);

        return java.util.stream.IntStream
            .of(dp[land.length-1])
            .max()
            .getAsInt();
    }
}
