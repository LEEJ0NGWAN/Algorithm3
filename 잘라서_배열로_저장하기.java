class Solution {

    public String[] solution(String my_str, int n) {

        return java.util.stream.IntStream
            .range(0, my_str.length())
            .filter(x -> x%n==0)
            .mapToObj(x -> my_str.substring(x, Math.min(x+n, my_str.length())))
            .toArray(String[]::new);
    }
}
