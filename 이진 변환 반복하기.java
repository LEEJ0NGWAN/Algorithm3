class Solution {

    public int[] solution(String s) {

        final int[] answer = { 0, 0 };

        while (!s.equals("1")) {

            final int ones = (int) s
            .chars()
            .filter(c -> c=='1')
            .count();

            answer[0]++;
            answer[1]+=s.length()-ones;

            s = Integer.toBinaryString(ones);
        }

        return answer;
    }
}
