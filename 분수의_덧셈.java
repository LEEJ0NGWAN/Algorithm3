class Solution {
    
    public static int gdc(int a, int b) {

        if (a < b) { a+=b;b=a-b;a=a-b; }
        while (b != 0) { int r=a%b;a=b;b=r; }
        return a;
    }

    public int[] solution(int denum1, int num1, int denum2, int num2) {

        final int denum = denum1*num2 + denum2*num1;
        final int num = num1*num2;
        final int gdc = gdc(denum,num);

        return new int[]{denum/gdc,num/gdc};
    }
}
