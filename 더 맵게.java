class Solution {

    public int solution(int[] scoville, int K) {

        final java.util.PriorityQueue<Integer> pq =
        new java.util.PriorityQueue<>();

        for (int s: scoville) pq.offer(s);

        int answer = 0;
        while (!pq.isEmpty()) {

            final int x = pq.poll();

            if (x >= K) return answer;
            if (pq.isEmpty()) break;

            final int y = pq.poll();

            pq.offer(x+2*y);
            answer++;
        }
        
        return -1;
    }
}
