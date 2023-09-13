class Solution {

    public int solution(int[] num_list) {

        return java.util.stream.IntStream
            .of(num_list)
            .collect(
                ()-> new int[3],
                (arr, x)-> arr[2] = (arr[x%2]=arr[x%2]*10+x)+arr[1-(x%2)],
                (arr1, arr2)-> {})[2];
    }
}
