import java.util.Arrays;

class 직사각형_넓이_구하기 {

    public int solution(int[][] dots) {

        Arrays.sort(
            dots,
            (x, y) -> x[0]==y[0]? x[1]-y[1]: x[0]-y[0]);

        return
            (dots[3][0]-dots[0][0])*
            (dots[3][1]-dots[0][1]);
    }
}
