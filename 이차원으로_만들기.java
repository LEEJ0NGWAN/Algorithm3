class Solution {

    public int[][] solution(int[] num_list, int n) {

        return java.util.stream.IntStream
            .range(0, num_list.length)
            .filter(x -> x%n==0)
            .mapToObj(x -> java.util.stream.IntStream
                      .range(x, x+n).map(y -> num_list[y]).toArray())
            .toArray(int[][]::new);
    }
}
