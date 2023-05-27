class Solution {

    private static final String directionOrder = "UDLR";
    private static final int[][] movementAmount = {{1,0},{-1,0},{0,-1},{0,1}};
    private static final int maxDistance = 5;
    private static final int maxSize = 1+maxDistance*2;

    public int solution(String dirs) {

        final java.util.Set<String> history = new java.util.HashSet<>();
        final int[] now = { maxDistance, maxDistance };

        int answer = 0;
        for (char d: dirs.toCharArray()) {

            final int index = directionOrder.indexOf(d);
            final int[] amount = movementAmount[index];

            final String prev = ""+now[0]+now[1];
            for (int i=0; i<2; now[i]+=amount[i++]);

            boolean isReachable = true;
            for (int i=0; i<2; isReachable &= (0<=now[i]&now[i++]<maxSize));
            if (isReachable) {

                final String next = ""+now[0]+now[1];
                final boolean reverse = amount[0]+amount[1]<0;
                if (history.add(reverse?next+prev:prev+next))
                answer++;
            }
            else for (int i=0; i<2; now[i]-=amount[i++]);
        }

        return answer;
    }
}
