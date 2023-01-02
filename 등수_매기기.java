class Solution {

    public int[] solution(int[][] score) {

        final int[] arr = new int[201];

        for (int[] s: score) arr[s[0]+s[1]]++;
        for (int i=200, j=1; i>=0; i--)
        if (arr[i] != 0) { j += arr[i]; arr[i] = j-arr[i]; }

        return java.util.Arrays
            .stream(score)
            .mapToInt(s -> arr[s[0]+s[1]])
            .toArray();
    }
}
