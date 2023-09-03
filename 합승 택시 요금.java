class Solution {

    private static final int INF = 2000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        final int[][] edges = new int[n+1][n+1];
        for (int i=1; i<=n;
             java.util.Arrays.fill(edges[i], INF), edges[i][i++] = 0);

        java.util.Arrays
            .stream(fares)
            .forEach(fare->
                    edges[fare[0]][fare[1]] =
                    edges[fare[1]][fare[0]] = fare[2]);

        for (int k=1; k<=n; k++)
        for (int i=1; i<=n; i++)
        for (int j=1; j<=n; j++)
        edges[i][j] = Math.min(edges[i][j], edges[i][k]+edges[k][j]);

        return java.util.stream.IntStream
            .range(1,n+1)
            .map(i -> edges[s][i]+edges[i][a]+edges[i][b])
            .min()
            .getAsInt();
    }
}
