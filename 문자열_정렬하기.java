class Solution {

    public int[] solution(String my_string) {

        return my_string
            .chars()
            .filter(Character::isDigit)
            .map(c -> c-48)
            .sorted()
            .toArray();
    }
}
