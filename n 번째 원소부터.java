class Solution {

    public int[] solution(int[] num_list, int n) {

        return java.util.stream.IntStream
            .range(n-1, num_list.length)
            .map(index-> num_list[index])
            .toArray();
    }
}
