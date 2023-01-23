class Solution {

    public int solution(String[] spell, String[] dic) {

        int mask = 0, bit = 0;

        for (final String s: spell) mask |= (1 << s.charAt(0)-97);
        for (final String s: dic)
        if ((bit = mask==bit? bit: 0)==1) return 1; else
        for (int c: s.toCharArray())
        if (((c = 1<<(c-97))&mask)!=0&&(c&bit)==0) bit |= c;
        else continue;

        return mask==bit? 1: 2;
    }
}
