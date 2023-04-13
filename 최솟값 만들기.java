class Solution {

    public long solution(int[] a, int[] b) {
        
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);

        return java.util.stream.IntStream.range(0, a.length).map(i -> a[i]*b[b.length-i-1]).sum();
    }
}
