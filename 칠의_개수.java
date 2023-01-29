class Solution {

    public long solution(int[] array) {

        return java.util.Arrays
            .stream(array)
            .flatMap(x -> String.valueOf(x).chars())
            .filter(c -> c=='7')
            .count();
    }
}
