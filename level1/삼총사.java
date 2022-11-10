public class 삼총사 {

    public int solution(final int[] arr) {

        final int l = arr.length;

        int answer = 0;

        for (int i = 0; i < l-2; i++)
        for (int j = i+1; j < l-1; j++)
        for (int k = j+1; k < l; k++)
        if (arr[i] + arr[j] + arr[k] == 0) answer++;

        return answer;
    }
}
