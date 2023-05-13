class Solution {

    public int solution(int[] numbers, int target) {

        final java.util.Queue<int[]> que = new java.util.ArrayDeque<>();

        que.offer(new int[] { numbers[0], 1});
        que.offer(new int[] {-numbers[0], 1});

        int answer = 0;
        while (!que.isEmpty()) {

            final int[] arr = que.poll();

            if (arr[1]==numbers.length) {

                if (arr[0]==target) ++answer;
                continue;
            }

            que.offer(new int[]{arr[0]+numbers[arr[1]],arr[1]+1});
            arr[0]-=numbers[arr[1]++];
            que.offer(arr);
        }

        return answer;
    }
}
