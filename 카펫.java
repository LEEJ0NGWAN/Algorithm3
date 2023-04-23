class Solution {

    public int[] solution(int brown, int yellow) {

        final int[] answer = {0,0};
        final int sum = brown+yellow;

        for (int w=3, h=3, l=(int)Math.sqrt(sum); h<=l; h++)
        if (sum%h==0&&((w=sum/h)-2)*(h-2)==yellow) {

            answer[0] = w; answer[1] = h; break;
        }

        return answer;
    }
}
