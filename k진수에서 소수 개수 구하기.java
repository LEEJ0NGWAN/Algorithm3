class Solution {

    private static final java.util.regex.Pattern
    pattern = java.util.regex.Pattern.compile("[1-9]+");

    private static boolean isPrime(long n) {

        if (n<2) return false;
        for (int i=2, l=(int)Math.sqrt(n)+1; i<l; i++)
        if (n%i==0) return false;
        return true;
    }

    public int solution(int n, int k) {

        final String parsed = Integer.toString(n,k);
        final java.util.regex.Matcher matcher = pattern.matcher(parsed);

        int answer = 0;
        while (matcher.find())
        if (isPrime(Long.parseLong(matcher.group()))) ++answer;
        return answer;
    }
}
