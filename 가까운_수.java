class Solution {

    public int solution(int[] array, int n) {

        return java.util.Arrays
            .stream(array)
            .mapToObj(x -> new int[] { x, Math.abs(x-n) })
            .sorted((a,b) -> a[1]==b[1]? a[0]-b[0]: a[1]-b[1])
            .findFirst()
            .get()[0];
    }
}
