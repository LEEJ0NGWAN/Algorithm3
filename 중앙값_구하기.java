class Solution {

    public int solution(int[] array) {
        
        java.util.Arrays.sort(array);

        return array[array.length/2];
    }
}
