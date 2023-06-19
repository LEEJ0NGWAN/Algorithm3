class Solution {

    public int solution(int bridge_length, int weight, int[] trucks) {

        int answer = 1;

        final java.util.Deque<int[]> deque = new java.util.ArrayDeque<>();
        for (int truck: trucks) {

            while (!deque.isEmpty()&&(deque.peek()[0]+bridge_length<=answer))
                weight+=deque.poll()[1];
            while (truck>weight) {

                final int[] info = deque.poll();
                answer = info[0]+bridge_length;
                weight+= info[1];
            }
            deque.offer(new int[]{answer++, truck});
            weight-=truck;
        }
        return deque.peekLast()[0]+bridge_length;
    }
}
