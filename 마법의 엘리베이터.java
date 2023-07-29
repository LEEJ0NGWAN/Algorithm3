class Solution {

    public int solution(int storey) {

        final java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[] {storey, 0});

        while (!pq.isEmpty()) {

            final int[] now = pq.poll();
            if (now[0]==0) return now[1];

            pq.offer(new int[] { now[0]/10+1, now[1]+(10-now[0]%10) });
            now[1] += now[0]%10; now[0] /= 10;
            pq.offer(now);
        }

        return 0;
    }
}
