class Solution {

    public int solution(int[] array) {

        final int[] cnt = new int[1001];

        int answer = 0, max = 0;

        for (int n: array)
        if (++cnt[n] > max) { answer = n; max = cnt[n]; }
        else if (cnt[n] == max) answer = -1;

        return answer;
    }
}
