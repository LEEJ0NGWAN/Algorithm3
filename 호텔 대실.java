class Solution {

    public static int minutes(String hhmm) {

        final String[] tokens = hhmm.split(":");
        return Integer.parseInt(tokens[0])*60+Integer.parseInt(tokens[1]);
    }

    public int solution(String[][] book_time) {

        final int[][] times = java.util.Arrays
            .stream(book_time)
            .map(time -> new int[] { minutes(time[0]), minutes(time[1])+10 })
            .sorted((a,b)->Integer.compare(a[0],b[0]))
            .toArray(int[][]::new);

        final java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

        int answer = 0;
        for (int[] time: times) {

            if (!pq.isEmpty()&&pq.peek()<=time[0]) pq.poll();
            pq.offer(time[1]);
            
            answer = Math.max(answer, pq.size());
        }

        return answer;
    }
}
