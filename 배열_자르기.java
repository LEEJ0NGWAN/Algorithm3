class Solution {

    public int[] solution(int[] numbers, int num1, int num2) {

        return java.util.stream.IntStream
            .range(num1, num2+1)
            .map(x -> numbers[x])
            .toArray();
    }
}
