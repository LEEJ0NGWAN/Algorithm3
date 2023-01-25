class Solution {

    public long solution(int balls, int share) {

        final int tmp = balls - Math.min(share, balls-share);

        return java.util.stream.LongStream
            .range(tmp+1, balls+1)
            .reduce(1, (y, x) -> (y * x) / (x-tmp));
    }
}
