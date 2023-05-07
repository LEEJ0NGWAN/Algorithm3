class Solution {

    private static int size = 10000;

    public int solution(int[] counts) {

        final int[] arr = new int[size+1];
        for (int count: counts) arr[count]++;
        for (int i=size, j=arr[size]; i>0; j+=arr[--i])
        if (j>=i) return i;
        return 0;
    }
}
