class Solution {

    public long solution(int order) {

        return String
            .valueOf(order)
            .chars()
            .filter(c -> c!=48&&(c-48)%3==0)
            .count();
    }
}
