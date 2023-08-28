class Solution {

    public int solution(String begin, String target, String[] words) {

        final int size = begin.length();
        final java.util.Queue<String> que = new java.util.ArrayDeque<>();
        final java.util.Map<String, Integer> visit = new java.util.HashMap<>();

        que.offer(begin);
        visit.put(begin, 0);

        while (!que.isEmpty()) {

            final String now = que.poll();
            final int count = visit.get(now);

            if (now.equals(target)) return count;
            for (String word: words)
            if (!visit.containsKey(word)) {

                int diff = 0;
                for (int i=0; i<size; diff+=now.charAt(i)==word.charAt(i++)? 0:1);
                if (diff==1) {

                    que.offer(word);
                    visit.put(word, count+1);
                }
            }
        }

        return 0;
    }
}
