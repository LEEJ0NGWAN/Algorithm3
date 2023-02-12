class Solution {

    public int solution(int num, int k) {

        return -Math
            .min(1, String
                 .valueOf(num)
                 .chars()
                 .reduce(1, (i,c) -> i<0? i: (c-48)==k? -i:i+1));
    }
}
