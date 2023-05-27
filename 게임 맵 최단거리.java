class Solution {

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    public int solution(int[][] maps) {

        final int h = maps.length;
        final int w = maps[0].length;
        final java.util.Queue<int[]> que = new java.util.ArrayDeque<>();

        maps[0][0] = 2;
        que.offer(new int[] {0,0,1});

        while (!que.isEmpty()) {

            final int[] pos = que.poll();

            if (pos[0]==h-1&&pos[1]==w-1) return pos[2];

            for (int i=0; i<4; i++) {

                final int y = pos[0]+dy[i];
                final int x = pos[1]+dx[i];

                if (0<=y&&y<h&&0<=x&&x<w&&maps[y][x]==1) {

                    maps[y][x]=2;
                    que.offer(new int[] {y,x,pos[2]+1});
                }
            }
        }

        return -1;
    }
}
