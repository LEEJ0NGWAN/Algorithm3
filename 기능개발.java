class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        for (int i=0, j=-1, k=-1; i<progresses.length; i++) {

            progresses[i] = (int)Math.ceil((float)(100-progresses[i])/speeds[i]);
            speeds[i] = 1;

            if (k < progresses[i]) k = progresses[j=i];
            else { speeds[i] = 0; speeds[j]++; }
        }

        return java.util.stream.IntStream
            .of(speeds)
            .filter(x -> x!=0)
            .toArray();
    }
}
