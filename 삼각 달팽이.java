class Solution {

    private static final int[] dy = {1,0,-1};
    private static final int[] dx = {0,1,-1};

    public int[] solution(int n) {

        final int[][] map = new int[n][n];

        int direction = 0, sequence = 1, y = -1, x = 0;
        while (n-->0) {

            for (int i=0; i<=n; i++)
            map[y += dy[direction]][x += dx[direction]] = sequence++;
            direction = ++direction%3;
        }

        return java.util.Arrays
            .stream(map)
            .flatMapToInt(java.util.stream.IntStream::of)
            .filter(e -> e>0)
            .toArray();
    }
}
