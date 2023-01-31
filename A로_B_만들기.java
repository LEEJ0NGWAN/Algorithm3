class Solution {

    public int solution(String before, String after) {

        final int[] arr = new int[26];
        for (int i=0,l=before.length(); i<l; arr[before.charAt(i)-97]++,arr[after.charAt(i++)-97]--);

        return java.util.Arrays
            .stream(arr)
            .filter(x -> x==0)
            .count() == 26? 1: 0;
    }
}
