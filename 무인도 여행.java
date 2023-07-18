class Solution {

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    public int[] solution(String[] maps) {

        final java.util.List<Integer> answer = new java.util.ArrayList<>();
        final java.util.Queue<int[]> que = new java.util.ArrayDeque<>();
        final char[][] map = java.util.Arrays
            .stream(maps)
            .map(String::toCharArray)
            .toArray(char[][]::new);

        for (int i=0; i<map.length; i++)
        for (int j=0; j<map[0].length; j++)
        if (map[i][j]!='X') {

            System.out.println(i+":"+j);
            que.offer(new int[]{i,j});
            answer.add(map[i][j]-'0');
            map[i][j] = 'X';

            while (!que.isEmpty()) {

                final int[] pos = que.poll();
                for (int k=0; k<4; k++) {

                    final int y = pos[0]+dy[k];
                    final int x = pos[1]+dx[k];

                    if (0<=y&&y<map.length&&0<=x&&x<map[0].length&&map[y][x]!='X') {

                        que.offer(new int[]{y,x});
                        answer.set(answer.size()-1, answer.get(answer.size()-1)+map[y][x]-'0');
                        map[y][x] = 'X';
                    }
                }
            }
        }

        return answer.isEmpty()?
            new int[] {-1}:
            answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
