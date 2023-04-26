class Solution {

    private static int gcd(int a, int b) { if (a<b) a=(a+=b)-(b=a-b); while (b>0) b=a%b+(a=b)-a; return a; }
    private static int lcm(int a, int b) { return a*b/gcd(a,b); }

    public int solution(int[] arr) {

        for (int i=1; i<arr.length; arr[i]=lcm(arr[i-1],arr[i++]));
        return arr[arr.length-1];
    }
}
