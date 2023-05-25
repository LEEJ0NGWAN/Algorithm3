class Solution {

    public int[] solution(int[] prices) {

        final java.util.Deque<int[]> deque = new java.util.ArrayDeque<>();

        deque.offerFirst(new int[] {prices[0],0});
        for (int i=1; i<prices.length; i++) {

            if (deque.peek()[0]>prices[i]) while (!deque.isEmpty()&&deque.peek()[0]>prices[i]) prices[deque.peek()[1]] = i-deque.poll()[1];

            deque.offerFirst(new int[]{prices[i],i});
        }
        
        while (!deque.isEmpty()) prices[deque.peek()[1]] = prices.length-1-deque.poll()[1];
        return prices;
    }
}
