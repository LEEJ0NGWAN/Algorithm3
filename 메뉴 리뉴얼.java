import java.util.Set;
import java.util.Map;
import java.util.List;

class Solution {

    private static final int MAX_SIZE = 20;
    private void dfs (
        StringBuilder course,
        Map<Character, Set<Integer>> menus, Map<Integer, Set<String>> newCourses,
        int[] maxCountPerCourseSize) {

        if (newCourses.containsKey(course.length())) {

            final Set<Integer> ordered = new java.util.HashSet<>(menus.get(course.charAt(0)));

            for (int i=1, l=course.length(); i<l; i++)
            ordered.retainAll(menus.get(course.charAt(i)));

            if (ordered.size()>=2) {

                if (maxCountPerCourseSize[course.length()]==ordered.size())
                newCourses.get(course.length()).add(course.toString());
                else
                if (maxCountPerCourseSize[course.length()]<ordered.size()) {

                    maxCountPerCourseSize[course.length()] = ordered.size();
                    newCourses.get(course.length()).clear();
                    newCourses.get(course.length()).add(course.toString());
                }
                
            }
        }

        final char startChar = course.length()==0? 'A': (char)(course.charAt(course.length()-1)+1);

        for (char c=startChar; c<='Z'; c++)
        if (menus.containsKey(c)) {

            course.append(c);
            dfs(course, menus, newCourses, maxCountPerCourseSize);
            course.deleteCharAt(course.length()-1);
        }
    }

    public String[] solution(String[] orders, int[] course) {

        final int[] maxCountPerCourseSize = new int[MAX_SIZE+1];
        final Map<Integer, Set<String>> newCourses = new java.util.HashMap<>();

        for (int c: course)
        newCourses.put(c, new java.util.HashSet<>());

        final Map<Character, Set<Integer>> menus = new java.util.HashMap<>();
        for (int i=0; i<orders.length; i++)
        for (char c: orders[i].toCharArray()) {

            if (!menus.containsKey(c))
            menus.put(c, new java.util.HashSet<>());
            menus.get(c).add(i);
        }

        dfs(new StringBuilder(), menus, newCourses, maxCountPerCourseSize);

        return newCourses
            .values()
            .stream()
            .flatMap(value -> value.stream())
            .sorted((a,b)-> a.compareTo(b))
            .toArray(String[]::new);
    }
}
