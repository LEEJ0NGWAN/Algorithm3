class Solution {

    public long solution(String[] s1, String[] s2) {

        final java.util.Set<String> set = new java.util.HashSet<>();

        return java.util.stream.Stream
            .concat(java.util.Arrays.stream(s1), java.util.Arrays.stream(s2))
            .filter(x -> !set.add(x))
            .count();
    }
}
