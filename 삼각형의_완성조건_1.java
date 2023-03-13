class Solution {

    public int solution(int[] sides) {

        return sides[0]+sides[1]+sides[2]-Math.max(Math.max(sides[0],sides[1]), sides[2])>Math.max(Math.max(sides[0],sides[1]),sides[2])? 1: 2;
    }
}
