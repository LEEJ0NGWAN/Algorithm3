class Solution {

    public int[] solution(int[][] arr) {

        final int[] answer = {0,0};

        int size = arr.length;
        while (size>0) {

            for (int i=0; i<arr.length; i+=size)
            loop:
            for (int j=0; j<arr.length; j+=size) {

                final int type = arr[i][j];

                if (type==-1) continue;
                for (int dy=i,y=i+size; dy<y; dy++)
                for (int dx=j,x=j+size; dx<x; dx++)
                if (type!=arr[dy][dx]) continue loop;

                answer[type]++;
                for (int dy=i,y=i+size; dy<y; dy++)
                for (int dx=j,x=j+size; dx<x; dx++)
                arr[dy][dx] = -1;
            }
            size/=2;
        }
        
        return answer;
    }
}
