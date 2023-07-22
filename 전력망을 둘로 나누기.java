class Solution {

    public int solution(int n, int[][] wires) {

        final boolean[][] adj = new boolean[n+1][n+1];
        for (int[] wire: wires) adj[wire[0]][wire[1]] = adj[wire[1]][wire[0]] = true;

        int answer = Integer.MAX_VALUE;

        final java.util.Queue<Integer> que = new java.util.ArrayDeque<>();
        final java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int[] wire: wires) {

            adj[wire[0]][wire[1]] = adj[wire[1]][wire[0]] = false;
            list.clear();
            que.clear();

            final boolean[] visit = new boolean[n+1];
            for (int x=1; x<=n; x++) if (!visit[x]) {

                visit[x] = true;
                list.add(0);
                que.offer(x);

                while (!que.isEmpty()) {

                    final int p = que.poll();
                    list.set(list.size()-1, list.get(list.size()-1)+1);

                    for (int i=1; i<=n; i++)
                    if (adj[p][i]&&!visit[i]) {

                        visit[i] = true;
                        que.offer(i);
                    }
                }
            }
            if (list.size()==2) answer = Math.min(answer, Math.abs(list.get(0)-list.get(1)));
            adj[wire[0]][wire[1]] = adj[wire[1]][wire[0]] = true;
        }

        return answer;
    }
}
