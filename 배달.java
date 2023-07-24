class Solution {

    public long solution(int N, int[][] road, int K) {

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
}
