import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    public int solution(int[] topping) {

        int answer = 0;

        final Map<Integer, AtomicInteger> left = new HashMap<>();
        final Map<Integer, AtomicInteger> right = new HashMap<>();

        for (int t: topping)
        if (right.containsKey(t))
        right.get(t).incrementAndGet();
        else right.put(t, new AtomicInteger(1));

        for (int t: topping) {

            if (left.containsKey(t)) left.get(t).incrementAndGet();
            else left.put(t, new AtomicInteger(1));
            if (right.get(t).decrementAndGet()==0) right.remove(t);
            if (left.size()==right.size()) answer++;
        }
        return answer;
    }
}
