class Solution {

    // direction
    // 0: up 1: right 2: down 3: left
    // L: -1 R: +1
    private static final int[] dy = { -1, 0, 1, 0 };
    private static final int[] dx = { 0, 1, 0, -1 };

    public int[] solution(String[] grid) {

        final int h = grid.length, w = grid[0].length();

        final java.util.Set<String> edges = new java.util.HashSet<>();
        final java.util.List<Integer> cycles = new java.util.ArrayList<>();

        for (int i=0; i<h; i++)
        for (int j=0; j<w; j++)
        for (int k=0; k<4; k++)
        calculate(grid, i, j, k, edges, cycles);

        return cycles
            .stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
    }

    private void calculate(
        String[] grid, int y, int x, int direction,
        java.util.Set<String> edges, java.util.List<Integer> cycles) {

        final int h = grid.length, w = grid[0].length();
        final java.util.Set<String> visit = new java.util.HashSet<>();

        String key = y+","+x+","+direction;

        while (!visit.contains(key)) {

            if (edges.contains(key)) return;

            visit.add(key);
            edges.add(key);

            direction = (4 + direction + ("LSR".indexOf(grid[y].charAt(x)) - 1)) % 4;

            y = (h + y + dy[direction]) % h;
            x = (w + x + dx[direction]) % w;

            key = y+","+x+","+direction;
        }

        cycles.add(visit.size());
    }
}
