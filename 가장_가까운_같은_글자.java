class 가장_가까운_같은_글자 {

    public int[] solution(String s) {

        final int[] pos = new int[26];
        final int[] ans = new int[s.length()];

        for (int i=0; i<26; pos[i++]=-1);
        for (int c=0,i=0,l=s.length(); i<l;
             ans[i] = pos[(c = s.charAt(i)-97)]==-1? -1: i-pos[c],
             pos[c] = i++);

        return ans;
    }
}