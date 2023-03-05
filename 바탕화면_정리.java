class Solution {

    public int[] solution(String[] wallpaper) {

        final int h = wallpaper.length, w = wallpaper[0].length();

        int ly=-1,lx=-1,ry=-1,rx=-1;

        for (int i=0; i<h; i++)
        for (int j=0; j<w; j++)
        if  (wallpaper[i].charAt(j)=='#') {

            if (lx==-1 || j<lx) lx = j;
            if (ly==-1 || i<ly) ly = i;
            rx = Math.max(rx, j);
            ry = Math.max(ry, i);
        }

        return new int[] {ly,lx,ry+1,rx+1};
    }
}
