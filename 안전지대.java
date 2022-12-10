import java.util.stream.Stream;
import java.util.stream.IntStream;

class 안전지대 {

    private static final int[] dx = {0,1,1,1,0,-1,-1,-1};
    private static final int[] dy = {-1,-1,0,1,1,1,0,-1};

    public long solution(int[][] board) {

        for (int i=0,h=board.length; i<h; i++)
        for (int j=0,w=board[0].length; j<w; j++)
        if  (board[i][j]==1) for (int k=0; k<8; k++)
        if  (0<=i+dy[k]&&i+dy[k]<h&&0<=j+dx[k]&&j+dx[k]<w&&board[i+dy[k]][j+dx[k]]==0)
        board[i+dy[k]][j+dx[k]]=2;

        return Stream.of(board).flatMapToInt(IntStream::of).filter(x -> x==0).count();
    }
}