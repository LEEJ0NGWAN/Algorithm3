class Solution {

    public int solution(int n) {

        int divisors = 0, sumablePairs = 0;

        final double sqrt = Math.sqrt(n);

        for (int i=1; i<=sqrt; i++) if (n%i==0) {

            final int pair = n/i;
            divisors += i==pair? 1: 2;

            if ((pair+i)%2!=0) sumablePairs++;
        }

        return n%2==0? sumablePairs: divisors;
    }
}
