class Solution {

    public long solution(String my_string) {

        return my_string
            .chars()
            .filter(Character::isDigit)
            .map(x -> x-48)
            .sum();
    }
}
