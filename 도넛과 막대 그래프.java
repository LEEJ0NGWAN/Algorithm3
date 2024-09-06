class Solution {

    public int[] solution(int[][] edges) {

        final int[] answer = { -1, 0, 0, 0 };

        final java.util.Map<Integer, java.util.List<Integer>> inboundEdges = new java.util.HashMap<>();
        final java.util.Map<Integer, java.util.List<Integer>> outboundEdges = new java.util.HashMap<>();
        final java.util.Queue<Integer> coreCandidates = new java.util.ArrayDeque<>();

        for (int[] edge: edges) {

            inboundEdges
                .compute(edge[1], (k, v)-> v == null? new java.util.ArrayList<>(): v)
                .add(edge[0]);
            outboundEdges
                .compute(edge[0], (k, v)-> v == null? new java.util.ArrayList<>(): v)
                .add(edge[1]);

            if (!inboundEdges.containsKey(edge[0])) {

                if (answer[0] == -1) answer[0] = edge[0];

                else if (outboundEdges.get(answer[0]).size() < outboundEdges.get(edge[0]).size()) {

                    coreCandidates.clear();
                    answer[0] = edge[0];
                }

                else if (outboundEdges.get(answer[0]).size() == outboundEdges.get(edge[0]).size()) {

                    coreCandidates.offer(edge[0]);
                }
            }

            if (inboundEdges.containsKey(answer[0]))
            while (!coreCandidates.isEmpty()) {

                final int coreCandidate = coreCandidates.poll();

                if (inboundEdges.containsKey(coreCandidate)) continue;

                answer[0] = coreCandidate;
                break;
            }

            if (inboundEdges.containsKey(answer[0])) answer[0] = -1;
        }

        outboundEdges
            .get(answer[0])
            .forEach(start-> {

                int next = start;
                do {

                    if (!outboundEdges.containsKey(next)) {

                        answer[2]++;
                        break;
                    }

                    else if (outboundEdges.get(next).size()==2) {

                        answer[3]++;
                        break;
                    }

                    next = outboundEdges.get(next).get(0);

                    if (next == start) answer[1]++;

                } while (next != start);
            });

        return answer;
    }
}
