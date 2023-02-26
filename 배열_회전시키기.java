class Solution {

    public int[] solution(int[] numbers, String direction) {

        final int index = "right".length()-direction.length();
        final int[] arr = new int[numbers.length];

        System.arraycopy(numbers, index, arr, 1-index, numbers.length-1);

        arr[(numbers.length-index)%numbers.length] =
        numbers[(numbers.length+index-1)%numbers.length];

        return arr;
    }
}
