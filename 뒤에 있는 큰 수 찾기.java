class Solution {

    public int[] solution(int[] numbers) {

        final java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();

        for (int i=0; i<numbers.length; i++) {

            while (!deque.isEmpty()) {

                final Integer index = deque.pollLast();

                if (numbers[index]>=numbers[i]) {

                    deque.offer(index);
                    break;
                }
                numbers[index] = numbers[i];
            }
            deque.offer(i);
        }
        while (!deque.isEmpty()) numbers[deque.pollLast()] = -1;

        return numbers;
    }
}
