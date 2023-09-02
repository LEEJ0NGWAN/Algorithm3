class Solution {

    public int solution(int[][] arr) {

        return java.util.stream.IntStream
            .range(0, arr.length)
            .map(pivot -> {

                int a = 0, b = 0;
                for (int i=0; i<pivot; a+=arr[pivot][i++]);
                for (int i=pivot+1; i<arr.length; b+=arr[pivot][i++]);

                return a - b;
            })
            .sum() == 0? 1: 0;
    }
}
