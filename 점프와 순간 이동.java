public class Solution {

    public int solution(int n) {

        int k=0; while ((n%2==1?--n+(++k-k):n)>0) n/=2; return k;
    }
}
