class Solution {

    public int solution(int n, int[][] edge) {

        final boolean[][] map = new boolean[n+1][n+1];
        for (int[] e: edge) map[e[0]][e[1]] = map[e[1]][e[0]] = true;

        final java.util.Queue<Integer> que = new java.util.ArrayDeque<>();
        final java.util.Map<Integer, Integer> visit = new java.util.HashMap<>();

        que.offer(1);
        visit.put(1,0);

        int currentDistance = 0, currentNodeCount = 1;

        while (!que.isEmpty()) {

            final int now = que.poll();
            final int distance = visit.get(now);

            if (currentDistance < distance) {

                currentDistance = distance;
                currentNodeCount = 1;
            }
            else if (currentDistance==distance) currentNodeCount++;

            for (int i=1; i<=n; i++)
            if (map[now][i]&&!visit.containsKey(i)) {

                que.offer(i);
                visit.put(i,distance+1);
            }
        }

        return currentNodeCount;
    }
}
