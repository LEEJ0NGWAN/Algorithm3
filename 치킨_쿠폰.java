class Solution {

    public int solution(int chicken) {

        int ans = 0;

        do ans += chicken/10;
        while ((chicken = chicken/10 + chicken%10) >= 10);

        return ans;
    }
}
