class Solution {

    private static final int hitTime = 1;
    private static final int missTime = 5;

    public int solution(int cacheSize, String[] cities) {

        int answer = 0;

        final java.util.List<String> cache = new java.util.LinkedList<>();

        for (int i=0; i<cities.length; i++) {

            final String city = cities[i].toLowerCase();
            final java.util.Iterator<String> iterator = cache.iterator();

            boolean hit = false;
            while (!hit&&iterator.hasNext())
            if (hit = iterator.next().equals(city)) iterator.remove();

            answer += hit? hitTime: missTime;
            cache.add(city);

            if (!hit&&cacheSize<cache.size()) cache.remove(cache.get(0));
        }
        return answer;
    }
}
