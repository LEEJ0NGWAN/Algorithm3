import static java.util.Arrays.stream;

public class 겹치는_선분의_길이 {

    public long solution(int[][] lines) {

        final int[] arr = new int[201];

        for(int[] line: lines) for(int i=line[0]+100; i<line[1]+100; arr[i++]++);

        return stream(arr).filter(x -> x>1).count();
    }
}
