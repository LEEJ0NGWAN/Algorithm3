class Solution {

    public int solution(int n, int s, int a, int b, int[][] fares) {

        final int[][] edges = java.util.Arrays
            .stream(fares)
            .collect(
                ()-> new int[n+1][n+1],
                (arr, fare)->
                    arr[fare[0]][fare[1]] =
                    arr[fare[1]][fare[0]] = fare[2],
                (arr1, arr2)-> {});

        final int[] commonDistance = dijkstra(n, s, edges);

        int answer = Integer.MAX_VALUE;

        for (int i=1; i<=n; i++)
        if (commonDistance[i]<Integer.MAX_VALUE) {

            final int[] eachDistance =
                i==s? commonDistance: dijkstra(n, i, edges);

            final int totalCost =
                commonDistance[i]+eachDistance[a]+eachDistance[b];

            answer = Math.min(answer, totalCost);
        }

        return answer;
    }

    public int[] dijkstra(int n, int start, int[][] edges) {

        final int[] dist = new int[n+1];
        for (int i=1; i<=n; dist[i++] = Integer.MAX_VALUE);

        final java.util.PriorityQueue<Integer> pq =
        new java.util.PriorityQueue<>((a,b)-> Integer.compare(dist[b], dist[a]));

        pq.offer(start);
        dist[start] = 0;

        while (!pq.isEmpty()) {

            final int now = pq.poll();
            for (int i=1; i<=n; i++)
            if (edges[now][i]!=0)
            if (dist[i] > dist[now]+edges[now][i]) {

                dist[i] = dist[now]+edges[now][i];
                pq.offer(i);
            }
        }

        return dist;
    }
}
