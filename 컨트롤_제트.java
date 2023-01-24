class Solution {

    public int solution(String s) {
        
        return java.util.Arrays
            .stream(java.util.Optional
                    .of(s.replaceAll("[-]?\\d+\\s[Z]{1}\\s?", ""))
                    .filter(r -> !r.isEmpty())
                    .orElse("0")
                    .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .reduce(0, (y, x) -> y+x);
    }
}
