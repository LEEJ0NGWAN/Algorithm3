class Solution {

    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(\\d+)");

    public int[] solution(String s) {

        final java.util.regex.Matcher matcher = pattern.matcher(s);
        final java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

        Integer element;
        while (matcher.find())
        map.put(element=Integer.valueOf(matcher.group(1)), map.getOrDefault(element,0)+1);

        return map
            .entrySet()
            .stream()
            .sorted((a,b)->Integer.compare(b.getValue(),a.getValue()))
            .mapToInt(entry -> entry.getKey())
            .toArray();
    }
}
