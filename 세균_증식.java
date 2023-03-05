class Solution {

    public int solution(int n, int t) {

        return java.util.stream.IntStream
            .range(0,t)
            .reduce(n, (y,x) -> 2*y);
    }
}
