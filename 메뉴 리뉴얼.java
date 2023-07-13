import java.util.Map;
import java.util.List;

class Solution {

    public void dfs(char[] order, StringBuilder courseBuilder, int courseSize, int menuIndex, Map<String, Integer> courses) {

        if (courseBuilder.length()==courseSize) {

            final String course = courseBuilder.toString();
            courses.put(course, courses.getOrDefault(course, 0)+1);

            if (courses.get(null)<courses.get(course))
                courses.put(null, courses.get(course));
        }
        else for (int i=menuIndex+1; i<order.length; i++) {

            courseBuilder.append(order[i]);
            dfs(order,courseBuilder,courseSize,i,courses);
            courseBuilder.deleteCharAt(courseBuilder.length()-1);
        }
    }

    public String[] solution(String[] orders, int[] course) {

        final List<String> answer = new java.util.ArrayList<>();
        final Map<String, Integer> courses = new java.util.HashMap<>();

        final char[][] orderArray = java.util.Arrays
            .stream(orders)
            .map(String::toCharArray)
            .toArray(char[][]::new);
        for (char[] order: orderArray)
        java.util.Arrays.sort(order);

        for (int courseSize: course) {

            courses.clear();
            courses.put(null, 2);

            for (char[] order: orderArray)
            if (order.length>=courseSize) {

                dfs(order, new StringBuilder(), courseSize, -1, courses);
            }

            final int mostOrderedCount = courses.remove(null);

            courses
                .entrySet()
                .stream()
                .filter(e -> e.getValue()==mostOrderedCount)
                .forEach(e -> answer.add(e.getKey()));
        }

        return answer
            .stream()
            .sorted()
            .toArray(String[]::new);
    }
}
