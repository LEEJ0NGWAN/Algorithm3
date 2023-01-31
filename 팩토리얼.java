class Solution {

    public int solution(int n) {

        int ans = 1; for (int x=1; x<=n; x*=++ans); return ans-1;
    }
}
