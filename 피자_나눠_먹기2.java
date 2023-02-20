class Solution {

    private static final int P = 6;

    public static int gcd(int a, int b) {

        if (a<b) { b=(a+=b)-b;a-=b; }
        while (b>0) { b=(a=(a%b)+b)-b;a-=b; }
        return a;
    }

    public int solution(int n) {

        return (n*P)/gcd(n,P)/P;
    }
}
