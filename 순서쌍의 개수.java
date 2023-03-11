class Solution {

    public long solution(int n) {

        final double sqrt = Math.sqrt(n);

        return java.util.stream.IntStream
            .range(1, (int)sqrt+1)
            .filter(x -> n%x==0)
            .count() * 2 - ((int)sqrt==sqrt? 1:0);
    }
}
