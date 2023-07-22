class Solution {

    public static int dfs(int[] info, int[][] edges, boolean[] visit, int node, int sheep, int wolf) {

        if (info[node]==0) sheep++; else wolf++;
        if (sheep<=wolf) return sheep;

        int maxSheep = sheep;
        for (int[] edge: edges)
        if (visit[edge[0]]&&!visit[edge[1]]) {

            visit[edge[1]] = true;
            maxSheep = Math.max(maxSheep, dfs(info,edges,visit,edge[1],sheep,wolf));
            visit[edge[1]] = false;
        }

        return maxSheep;
    }

    public int solution(int[] info, int[][] edges) {

        final boolean[] visit = new boolean[info.length]; visit[0] = true;
        return dfs(info, edges, visit, 0, 0, 0);
    }
}
