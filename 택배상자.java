class Solution {
    public int solution(int[] order) {
        int index = 0, now = 1;
        final java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();

        while (index<order.length) {
            final int cache = deque.isEmpty()? -1: deque.peekLast();
            if (order[index]==cache) { deque.pollLast(); index++; continue; }
            if (now>order[index]) break;
            while (now<order[index]) deque.offer(now++);
            now++; index++;
}
        
        return index;
    }
}
