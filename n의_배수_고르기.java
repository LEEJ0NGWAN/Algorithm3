class Solution {

    public int[] solution(int n, int[] numlist) {

        return java.util.Arrays.stream(numlist).filter(x->x%n==0).toArray();
    }
}
