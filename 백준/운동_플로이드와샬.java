import static java.lang.Math.min;
import static java.util.Arrays.fill;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 운동_플로이드와샬 {

    private static final int MAX_DIST = 10000000;

    private static final BufferedReader br =
    new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        String[] tokens = br.readLine().split(" ");

        final int v = parseInt(tokens[0]);
        final int e = parseInt(tokens[1]);

        final int[][] dist = new int[v+1][v+1];

        for (int i=1; i<=v; dist[i][i++] = 0) fill(dist[i], MAX_DIST);

        for (int i=0; i<e; i++) {

            tokens = br.readLine().split(" ");
            dist[parseInt(tokens[0])][parseInt(tokens[1])] = parseInt(tokens[2]);
        }

        for (int k=1; k<=v; k++)
        for (int i=1; i<=v; i++)
        for (int j=1; j<=v; j++)
        dist[i][j] = min(dist[i][j], dist[i][k]+dist[k][j]);

        int minCycle = MAX_DIST;

        for (int i=1; i<v; i++) for (int j=i+1; j<=v; j++)
        minCycle = min(minCycle, dist[i][j]+dist[j][i]);

        System.out.println(minCycle == MAX_DIST? -1: minCycle);
    }
}
