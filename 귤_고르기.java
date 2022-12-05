import java.util.HashMap;

class 귤_고르기 {

    public int solution(int k, int[] tangerine) {

        final int[] rest = {k};
        final HashMap<Integer, Integer> map = new HashMap<>();

        for (int t: tangerine) map.put(t, map.getOrDefault(t,0) + 1);

        return map
        .values()
        .stream()
        .sorted((a,b) -> Integer.valueOf(b-a))
        .reduce(0, (count, x) -> {

            if (rest[0] <= 0) return count;

            rest[0] -= x;
            return count+1;
        });
    }
}
