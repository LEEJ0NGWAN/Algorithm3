class Solution {

    public int[] solution(int[] numbers) {

        return java.util.stream.IntStream
            .of(numbers)
            .map(x -> 2*x)
            .toArray();
    }
}
