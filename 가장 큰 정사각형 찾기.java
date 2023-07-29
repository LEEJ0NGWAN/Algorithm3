class Solution {

    public int solution(int[][] board) {

        final int[][] dp = new int[board.length+1][board[0].length+1];

        int size = 0;
        for (int i=1; i<=board.length; i++)
        for (int j=1; j<=board[0].length; j++)
        if (board[i-1][j-1]==1)
        size = Math.max(size, dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1);

        return size*size;
    }
}
