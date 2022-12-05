import java.util.HashSet;

public class 연속_부분_수열_합의_개수 {

    public int solution(int[] elements) {

        final HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<elements.length; i++)
        for (int j=0, sum=0; j<elements.length;
             sum+=elements[(i+j++)%elements.length], set.add(sum));

        return set.size();
    }
}
