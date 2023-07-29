class Solution {

    private static final int[] dy = { -1,0,1,0 };
    private static final int[] dx = { 0,1,0,-1 };

    public int[] solution(String[][] places) {

        final int[] answer = new int[places.length];

        loop:
        for (int p=0, r=1; p<places.length; answer[p++]=r, r=1)
        for (int i=0; i<places[p].length; i++)
        for (int j=0; j<places[p][i].length(); j++)
        if (places[p][i].charAt(j)=='P') {

            final boolean[][] visit = new boolean[places[p].length][places[p][i].length()];
            final java.util.Queue<int[]> que = new java.util.ArrayDeque<>();

            que.offer(new int[] {i,j,0});
            visit[i][j] = true;

            while (!que.isEmpty()) {

                final int[] pos = que.poll();

                if (pos[2]<2)
                for (int k=0; k<4; k++) {

                    final int y = pos[0] + dy[k];
                    final int x = pos[1] + dx[k];

                    if (y<0||places[p].length<=y||x<0||places[p][i].length()<=x) continue;

                    if (visit[y][x]||places[p][y].charAt(x)=='X') continue;
                    if (places[p][y].charAt(x)=='P') { r=0; continue loop; }

                    visit[y][x] = true;
                    que.offer(new int[] {y,x,pos[2]+1});
                }
            }
        }

        return answer;
    }
}
