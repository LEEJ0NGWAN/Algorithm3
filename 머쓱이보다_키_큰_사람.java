class Solution {

    public long solution(int[] array, int height) {

        return java.util.Arrays
            .stream(array)
            .filter(x -> x>height)
            .count();
    }
}
