import java.util.ArrayList;

class Solution {
    
    public static int[][] rotate(int[][] arr) {

        final int size = arr.length;
        final int[][] rotated = new int[size][size];

        for (int i=0; i<size; i++)
        for (int j=0; j<size; rotated[size-1-j][i] = arr[i][j++]);

        return rotated;
    }
    
    public static void put
    (int[][] small, int[][] big, int y, int x) {

        for (int i=y, h=y+small.length; i<h; i++)
        for (int j=x, w=x+small.length; j<w; j++)
        if  (0<=i && i<big.length && 0<=j && j<big.length && big[i][j]+small[i-y][j-x]==2)
        return;

        for (int i=y, h=y+small.length; i<h; i++)
        for (int j=x, w=x+small.length; j<w; j++)
        if  (0<=i && i<big.length && 0<=j && j<big.length && small[i-y][j-x]==1)
        big[i][j] = small[i-y][j-x];
    }

    public boolean solution(int[][] key, int[][] lock) {

        final int keySize = key.length;
        final int lockSize = lock.length;
        final int mapSize = (keySize-1)+lockSize;

        final ArrayList<int[]> list = new ArrayList<>();

        for (int i=0; i<lockSize; i++)
        for (int j=0; j<lockSize; j++)
        if  (lock[i][j] == 0)
        list.add(new int[]{i+keySize-1,j+keySize-1});

        for (int k=0; k<4; k++, key=rotate(key))
        for (int i=0; i<mapSize; i++)
        for (int j=0; j<mapSize; j++) {

            final int[][] map = new int[mapSize][mapSize];

            put(lock, map, keySize-1, keySize-1);
            put(key, map, i, j);

            int count=0;
            for (int[] pos: list) {

                count += map[pos[0]][pos[1]];
                map[pos[0]][pos[1]] = 0;
            }

            if (count == list.size()) return true;
        }

        return false;
    }
}
