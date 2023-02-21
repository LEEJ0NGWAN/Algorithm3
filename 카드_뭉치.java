import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        final Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[] {0,0,0});

        while(!que.isEmpty()) {

            final int[] indexArray = que.poll();

            if (indexArray[2]==goal.length) return "Yes";

            if (indexArray[0]<cards1.length&&goal[indexArray[2]].equals(cards1[indexArray[0]]))
            que.add(new int[] {indexArray[0]+1,indexArray[1],indexArray[2]+1});

            if (indexArray[1]<cards2.length&&goal[indexArray[2]].equals(cards2[indexArray[1]]))
            que.add(new int[] {indexArray[0],indexArray[1]+1,indexArray[2]+1});
        }

        return "No";
    }
}
