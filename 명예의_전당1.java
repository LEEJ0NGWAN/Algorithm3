import java.util.PriorityQueue;

class 명예의_전당1 {

    public int[] solution(int k, int[] score) {

        final int[] answer = new int[score.length];

        final PriorityQueue<Integer> pq =
        new PriorityQueue<>((a,b) -> a-b);
        
        for (int i=0; i<score.length; i++) {

            pq.add(score[i]);

            if (pq.size() > k) pq.remove();
            
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}
