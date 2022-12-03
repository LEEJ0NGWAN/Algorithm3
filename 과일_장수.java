import java.util.Arrays;

class 과일_장수 {

    public int solution(int k, int m, int[] score) {

        if (score.length < m) return 0;
        
        Arrays.sort(score);

        int answer = 0;
        
        for (int i=score.length-1; i-m+1>=0;
             answer+=score[i-m+1]*m, i -= m);

        return answer;
    }
}
