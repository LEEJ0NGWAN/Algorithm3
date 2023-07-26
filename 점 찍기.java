class Solution {

    public long solution(long k, long d) {

        if (k>=d) return k==d? 3: 1;
        long answer = 0;
        final long distance = d*d;
        for (long i=0; i<=d; i+=k)
        answer += ((int)Math.sqrt(distance-(i*i))/k)+1;
        return answer;
    }
}
