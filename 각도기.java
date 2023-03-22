class Solution {

    private static final int[][] arr = {{0,1}, {2,3}, {4,5}};

    public int solution(int angle) {

        return arr[angle/90][angle%90==0?0:1];
    }
}
