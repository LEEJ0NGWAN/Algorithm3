class Solution {

    public int solution(int n, int[][] computers) {

        final boolean[] visit = new boolean[n];
        final java.util.Queue<Integer> que = new java.util.ArrayDeque<>();

        int answer = 0;
        for (int i=0; i<n; i++)
        if (!visit[i]) {

            answer++;
            que.offer(i);
            visit[i] = true;

            for (;!que.isEmpty();que.poll())
            for (int next=0; next<n; next++)
            if (computers[que.peek()][next]==1&&!visit[next]) {

                que.offer(next);
                visit[next] = true;
            }
        }

        return answer;
    }
}
