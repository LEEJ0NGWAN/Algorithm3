class Solution {

    public int solution(int[] box, int n) {

        return java.util.Arrays.stream(box).map(x->x/n).reduce(1,(y,x)->y*x);
    }
}
