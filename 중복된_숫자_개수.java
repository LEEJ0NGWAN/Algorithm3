class Solution {

    public long solution(int[] array, int n) {

        return java.util.Arrays
            .stream(array)
            .filter(x -> x==n)
            .count();
    }
}
