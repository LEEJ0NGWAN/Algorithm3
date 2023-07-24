class Solution {

    public long solution1(int N, int[][] road, int K) {

        final int[][] map = new int[N+1][N+1];
        for (int[] r: road)
            map[r[0]][r[1]]=map[r[1]][r[0]]=
            map[r[0]][r[1]]==0? r[2]: Math.min(map[r[0]][r[1]], r[2]);

        final java.util.PriorityQueue<Integer> pq =
            new java.util.PriorityQueue<>((a,b)->Integer.compare(a,b));

        final int[] distance = new int[N+1];
        for (int i=2; i<=N; distance[i++] = Integer.MAX_VALUE);

        pq.offer(1);
        while (!pq.isEmpty())
        for (int i=1, node=pq.poll(); i<=N; i++)
        if (map[node][i]!=0&&distance[i]>distance[node]+map[node][i]) {

            distance[i] = distance[node]+map[node][i];
            pq.offer(i);
        }

        return java.util.stream.IntStream
            .range(1,N+1)
            .filter(x -> distance[x]<=K)
            .count();
    }

    public long solution2(int N, int[][] road, int K) {

        final int[][] distance = new int[N+1][N+1];

        for (int i=1; i<=N; i++)
        for (int j=1; j<=N; j++)
        if (i!=j)
        distance[i][j] = distance[j][i] = 20000001;

        for (int[] r: road)
        distance[r[0]][r[1]] = distance[r[1]][r[0]] = Math.min(distance[r[0]][r[1]], r[2]);

        for (int i=1; i<=N; i++)
        for (int j=1; j<=N; j++)
        for (int k=1; k<=N; k++)
        distance[j][k] = Math.min(distance[j][k], distance[j][i]+distance[i][k]);

        return java.util.stream.IntStream
            .range(1,N+1)
            .filter(x -> distance[1][x]<=K)
            .count();
    }
}
