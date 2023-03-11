class Solution {

    public int[] solution(int[] num_list) {

        return java.util.stream.IntStream
            .range(0, num_list.length)
            .map(index -> num_list[num_list.length-index-1])
            .toArray();
    }
}
