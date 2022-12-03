import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    private static final int[] dx = { 0, 1, 0, -1 };
    private static final int[] dy = { -1, 0, 1, 0 };

    public int solution(int[][] maps) {

        final int n = maps.length, m = maps[0].length;
        final boolean[][] visit = new boolean[n][m];

        final Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { 0, 0, 1 });
        visit[0][0] = true;

        while (!queue.isEmpty()) {

            final int[] pos = queue.poll();

            if (pos[0]==n-1 && pos[1]==m-1) return pos[2];

            for (int i = 0; i < 4; i++) {

                final int y_ = pos[0] + dy[i];
                final int x_ = pos[1] + dx[i];

                if (y_<0 || n<=y_ || x_<0 || m<=x_ || maps[y_][x_]==0 || visit[y_][x_])
                continue;

                visit[y_][x_] = true;
                queue.add(new int[] {y_,x_,pos[2]+1});
            }
        }

        return -1;
    }
}
