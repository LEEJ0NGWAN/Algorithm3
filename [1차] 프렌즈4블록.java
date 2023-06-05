class Solution {

    public int solution(int m, int n, String[] board) {

        final char[][] map =
            java.util.Arrays
            .stream(board)
            .map(String::toCharArray)
            .toArray(char[][]::new);
        final int h=map.length-1, w=map[0].length-1;
        int totalCount=0;

        while (true) {

            int count = 0;
            final boolean[][] check = new boolean[map.length][map[0].length];
            for (int i=0; i<h; i++)
            for (int j=0; j<w; j++)
            if (map[i][j]!=0&&map[i][j]+map[i+1][j]+map[i][j+1]+map[i+1][j+1]==4*map[i][j])
            check[i][j]=check[i+1][j]=check[i][j+1]=check[i+1][j+1] = true;

            for (int i=0; i<map.length; i++)
            for (int j=0; j<map[0].length; j++)
            if (check[i][j]) {

                count++;
                check[i][j] = false;
                map[i][j] = 0;
            }

            for (int j=0; j<map[0].length; j++)
            for (int i=map.length-1; i>0; i--)
            if (map[i][j]==0)
            for (int k=i-1; k>=0; k--)
            if (map[k][j]!=0) {

                map[i][j] = map[k][j];
                map[k][j] = 0;
                break;
            }
            totalCount+=count;

            if (count==0) break;
        }
        return totalCount;
    }
}
