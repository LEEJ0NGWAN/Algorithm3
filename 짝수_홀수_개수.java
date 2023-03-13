class Solution {

    public int[] solution(int[] num_list) {

        return java.util.Arrays
            .stream(num_list)
            .collect(()->new int[2], (arr,x)->arr[x%2]++, (a,b)->{});
    }
}
