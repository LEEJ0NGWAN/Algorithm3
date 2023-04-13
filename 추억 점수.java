class Solution {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        final java.util.Map<String, Integer> scores = java.util.stream.IntStream
            .range(0, name.length)
            .collect(
                ()-> new java.util.HashMap<>(),
                (map,i)-> map.put(name[i], yearning[i]),
                (m1,m2)-> {});

        return java.util.Arrays
            .stream(photo)
            .map(java.util.Arrays::stream)
            .mapToInt(stream -> stream.mapToInt(man -> scores.getOrDefault(man, 0)).sum())
            .toArray();
    }
}
