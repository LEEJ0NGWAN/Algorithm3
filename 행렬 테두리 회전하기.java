class Solution {

    public static int rotate(int[][] map, int[] query) {

        final int r1 = query[0]-1, r2 = query[2]-1;
        final int c1 = query[1]-1, c2 = query[3]-1;

        int min = Integer.MAX_VALUE;
        final int[] point = {map[r1][c2],map[r2][c2],map[r2][c1]};
        for (int p: point) min = Math.min(p, min);
        for (int j=c2; c1<j; j--) min = Math.min(min, map[r1][j] = map[r1][j-1]);
        for (int i=r2; r1<i; i--) min = Math.min(min, map[i][c2] = map[i-1][c2]); map[r1+1][c2] = point[0];
        for (int j=c1; j<c2; j++) min = Math.min(min, map[r2][j] = map[r2][j+1]); map[r2][c2-1] = point[1];
        for (int i=r1; i<r2; i++) min = Math.min(min, map[i][c1] = map[i+1][c1]); map[r2-1][c1] = point[2];

        return min;
    }
    public int[] solution(int rows, int columns, int[][] queries) {

        final int[] answer = new int[queries.length];

        final int[][] map = new int[rows][columns];
        for (int i=0, x=1; i<map.length; i++)
        for (int j=0; j<map[0].length; map[i][j++]=x++);

        for (int i=0; i<queries.length; i++)
        answer[i] = rotate(map, queries[i]);

        return answer;
    }
}
