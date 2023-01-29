class Solution {

    public int solution(String my_string) {

        return java.util.Arrays
            .stream(my_string.split("[a-zA-Z]+"))
            .filter(x -> !x.isEmpty())
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
