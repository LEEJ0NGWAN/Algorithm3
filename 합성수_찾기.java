class Solution {

    private static final int[] arr = new int[101];
    static {

        arr[1] = 1;
        for (int i=2; i<=100; arr[i++]+=2)
        for (int j=i*2; j<=100; arr[j]+=1, j+=i);
    }

    public long solution(int n) {

        return java.util.stream.IntStream
            .range(1,n+1)
            .filter(x -> arr[x]>=3)
            .count();
    }
}
