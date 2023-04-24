class Solution {

    public int solution(int n, int a, int b) {

        if (a>b) a=(a+=b)-(b=a-b);

        int round = 1;

        while ((a=a/2+a%2)!=(b=b/2+b%2)) round++;

        return round;
    }
}
