class Solution {

    private static char lastChar(String s) { return s.charAt(s.length()-1); }

    public int[] solution(int n, String[] words) {

        final int[] answer = {0,0};
        final int[] rounds = new int[n];
        
        final java.util.Set<String> set = new java.util.HashSet<>();

        char lastChar = words[0].charAt(0);
        for (int i=0,j=0; i<words.length; rounds[j]++, j=++j%n, lastChar=lastChar(words[i++]))
        if (lastChar!=words[i].charAt(0)||set.contains(words[i])) {

            answer[0] = j+1; answer[1] = rounds[j]+1;
            break;
        }
        else set.add(words[i]);

        return answer;
    }
}
