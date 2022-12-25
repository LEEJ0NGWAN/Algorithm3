class Solution {

    public int solution(String t, String p) {

        int answer = 0;

        for (int i=0,l=t.length()-p.length()+1,m=1; i<l; answer+=m, m=1, i++)
        for (int j=i,n=i+p.length(); j<n; j++)
        if (t.charAt(j) < p.charAt(j-i)) break;
        else if (t.charAt(j) > p.charAt(j-i)) { m=0; break; }

        return answer;
    }
}
