class Solution {
    
    private static final int[] prime = new int[1001];
    static {

        for (int i=2; i<=1000; i++) if (prime[i]==0)
        for (int j=i*2; j<=1000; prime[j]=1, j+=i);
    }

    private static int gdc(int a, int b) {

        if (a < b) a=(a+=b)-(b=a-b);

        while (b != 0) { final int r = a%b; a=b; b=r; }

        return a;
    }
    
    private static boolean isUnexpectedPrime(int a) {

        return a!=1&&a!=2&&a!=5&&prime[a]==0;
    }

    public int solution(int a, int b) {

        for (int i=1,l=(int)Math.ceil(Math.sqrt((b/=gdc(a,b)))); i<l; i++)
        if (b%i==0&&(isUnexpectedPrime(i)||isUnexpectedPrime(b/i)))
        return 2;
        return 1;
    }
}
