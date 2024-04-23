class Solution {

    public int solution(String[] friends, String[] gifts) {

        int answer = 0;

        final java.util.Map<String, int[]> giveTakeCounts = new java.util.HashMap<>();
        final java.util.Map<String, java.util.Map<String, Integer>> takeMap = new java.util.HashMap<>();
        final java.util.Map<String, Integer> nextTakeCounts = new java.util.HashMap<>();

        for (String friend: friends) {

            takeMap.put(friend, new java.util.HashMap<>());
            giveTakeCounts.put(friend, new int[2]);
            nextTakeCounts.put(friend, 0);
        }

        for (String gift: gifts) {

            final String[] tokens = gift.split(" ");
            final String giver = tokens[0];
            final String taker = tokens[1];

            giveTakeCounts.get(taker)[0]++;
            giveTakeCounts.get(giver)[1]++;

            final java.util.Map<String, Integer> takeCounts = takeMap.get(taker);

            if (!takeCounts.containsKey(giver)) takeCounts.put(giver, 1);
            else takeCounts.put(giver, takeCounts.get(giver)+1);
        }

        for (int i=0; i<friends.length; i++)
        for (int j=i+1; j<friends.length; j++) {

            final String friendA = friends[i];
            final String friendB = friends[j];

            final int takeCountsFromB = takeMap.get(friendA).getOrDefault(friendB, 0);
            final int takeCountsFromA = takeMap.get(friendB).getOrDefault(friendA, 0);

            boolean friendAIsNextGiver = takeCountsFromB > takeCountsFromA;

            if (takeCountsFromB == takeCountsFromA) {

                final int[] giveTakeCountOfA = giveTakeCounts.get(friendA);
                final int[] giveTakeCountOfB = giveTakeCounts.get(friendB);

                final int presentLevelOfA = giveTakeCountOfA[1] - giveTakeCountOfA[0];
                final int presentLevelOfB = giveTakeCountOfB[1] - giveTakeCountOfB[0];

                if (presentLevelOfA == presentLevelOfB) continue;

                friendAIsNextGiver = presentLevelOfA < presentLevelOfB;
            }

            final String giver = friendAIsNextGiver? friendA: friendB;
            final String taker = friendAIsNextGiver? friendB: friendA;

            final int nextTakeCount = nextTakeCounts.get(taker)+1;
            nextTakeCounts.put(taker, nextTakeCount);

            answer = Math.max(answer, nextTakeCount);
        }

        return answer;
    }
}
