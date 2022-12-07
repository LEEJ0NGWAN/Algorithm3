import static java.lang.Math.min;
import static java.util.Optional.ofNullable;
import static java.util.Arrays.fill;
import static java.util.Arrays.stream;
import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 운동_다익스트라 {

    private static final BufferedReader br =
    new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int totalMinDist = MAX_VALUE;

        final int[] graphInfo =
        stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

        final int[] dist = new int[graphInfo[0]+1];
        final int[][] distInfo = new int[graphInfo[0]+1][graphInfo[0]+1];
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        if (graphInfo[1] <= 1) { System.out.println(-1); return; }

        for (int i=0; i<graphInfo[1]; i++)
        ofNullable(
            stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray())
        .ifPresent(arr -> distInfo[arr[0]][arr[1]] = arr[2]);

        for (int i=1; i<=graphInfo[0]; i++) {

            pq.clear(); fill(dist, MAX_VALUE);

            for (int j=1; j<=graphInfo[0]; j++) if (distInfo[i][j] != 0)
            pq.add(new int[] { j, (dist[j] = distInfo[i][j]) });

            while (!pq.isEmpty()) {

                final int[] now = pq.poll();

                for (int j=1; j<=graphInfo[0]; j++)
                if (distInfo[now[0]][j] != 0 && distInfo[now[0]][j] + now[1] < dist[j])
                pq.add(new int[] {j, (dist[j] = distInfo[now[0]][j] + now[1])});
            }

            if (dist[i] != MAX_VALUE) totalMinDist = min(totalMinDist, dist[i]);
        }

        System.out.println(totalMinDist == MAX_VALUE? -1: totalMinDist);
    }
}
