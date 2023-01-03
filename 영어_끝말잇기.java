import java.util.HashSet;

class Solution {

    public int[] solution(int n, String[] words) {

        final HashSet<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i=1; i<words.length; set.add(words[i++]))
        if (!words[i-1].endsWith(words[i].substring(0,1)) || set.contains(words[i]))
        return new int[] {i%n+1, i/n+1};

        return new int[] {0,0};
    }
}
