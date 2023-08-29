class Solution {

    public int solution(int[] num_list) {

        return java.util.stream.IntStream
            .range(0, num_list.length)
            .collect(
                ()-> new int[3],
                (arr,i)-> arr[2] = Math.max(arr[i%2]+=num_list[i], arr[1-i%2]),
                (arr1,arr2)-> {})[2];
    }
}
