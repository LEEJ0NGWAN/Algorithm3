class Solution {

    private static final int[][] arr = {{3,2},{4,1}};

    public int solution(int[] dot) {

        return arr[dot[0]>0?1:0][dot[1]>0?1:0];
    }
}
