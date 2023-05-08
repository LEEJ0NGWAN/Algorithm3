class Solution {

    public long[] solution(int n, long left, long right) {

        return java.util.stream.LongStream
            .range(left,right+1)
            .map(index -> Math.max(index%n,index/n)+1)
            .toArray();
    }
}
