class Solution {

    private static final int[] dy = { -1, 0, 1, 0 };
    private static final int[] dx = { 0, 1, 0, -1 };

    public int solution(String[] maps) {

        int[] start = null, end = null, lever = null;

        for (int i=0; i<maps.length; i++)
        for (int j=0; j<maps[0].length(); j++)
        switch (maps[i].charAt(j)) {
            case 'S': start = new int[] { i, j }; break;
            case 'E': end   = new int[] { i, j }; break;
            case 'L': lever = new int[] { i, j }; break;
        }

        final int startToLever = bfs(start, lever, maps);
        final int LeverToEnd = bfs(lever, end, maps);

        return startToLever<0||LeverToEnd<0? -1: startToLever+LeverToEnd;
    }

    private int bfs(int[] from, int[] to, String[] maps) {

        final boolean[][] visit = new boolean[maps.length][maps[0].length()];

        final java.util.Deque<int[]> que = new java.util.ArrayDeque<>();

        que.offer(new int[] { from[0], from[1], 0 });
        visit[from[0]][from[1]] = true;

        while (!que.isEmpty()) {

            final int[] now = que.poll();

            if (now[0]==to[0]&&now[1]==to[1]) return now[2];
            else for (int i=0; i<4; i++) {

                final int y = now[0]+dy[i];
                final int x = now[1]+dx[i];

                if (0<=y&&y<maps.length&&
                    0<=x&&x<maps[0].length()&&
                    maps[y].charAt(x)!='X'&&!visit[y][x]) {

                    que.offer(new int[]{ y, x, now[2]+1 });
                    visit[y][x] = true;
                }
            }
        }

        return -1;
    }
}
