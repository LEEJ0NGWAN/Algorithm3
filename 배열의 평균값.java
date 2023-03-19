class Solution {

    public double solution(int[] numbers) {

        return java.util.Arrays
            .stream(numbers)
            .average()
            .getAsDouble();
    }
}
