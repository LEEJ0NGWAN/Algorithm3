class Solution {

    public int solution(int[] queue1, int[] queue2) {

        final java.util.Queue<Integer> q1 = new java.util.ArrayDeque<>();
        final java.util.Queue<Integer> q2 = new java.util.ArrayDeque<>();

        long q1sum = 0, q2sum = 0;
        for (int x: queue1) { q1.offer(x); q1sum+=x; }
        for (int y: queue2) { q2.offer(y); q2sum+=y; }

        final long total = q1sum+q2sum, half = total/2;
        if (total%2==1) return -1;

        int count = 0, limit = 2*(q1.size()+q2.size());
        while (q1sum!=q2sum) {

            if (q1sum<q2sum) {

                final int y = q2.poll();
                q1.offer(y);
                q1sum += y;
                q2sum -= y;
            }
            else {

                final int x = q1.poll();
                q2.offer(x);
                q1sum -= x;
                q2sum += x;
            }
            if (++count==limit) return -1;
        }

        return count;
    }
}
