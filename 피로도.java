class Solution {

    public static int dfs(int k, int[][] dungeons, boolean[] visit) {

        int count = 0;
        for (boolean v: visit) if (v) ++count;

        if (k<=0) return count;
        for (int i=0; i<dungeons.length; i++)
        if (!visit[i]&&k>=dungeons[i][0]) {

            visit[i] = true;
            count = Math.max(count, dfs(k-dungeons[i][1],dungeons,visit));
            visit[i] = false;
        }
        return count;
    }

    public int solution(int k, int[][] dungeons) {

        return dfs(k,dungeons,new boolean[dungeons.length]);
    }
}
