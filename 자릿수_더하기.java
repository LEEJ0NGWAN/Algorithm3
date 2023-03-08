class Solution {

    public long solution(int n) {

        return String
            .valueOf(n)
            .chars()
            .map(x -> x-48)
            .sum();
    }
}
