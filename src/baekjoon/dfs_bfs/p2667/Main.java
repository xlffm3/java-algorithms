package baekjoon.dfs_bfs.p2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int clusterCounts = 0;
    private static int n;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] vertical = {-1, 1, 0, 0};
    private static int[] horizontal = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] inputArray = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                graph[i][j] = inputArray[j] - '0';
            }
        }

        List<Integer> houseCountsPerCluster = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    clusterCounts = 1;
                    dfs(i, j);
                    houseCountsPerCluster.add(clusterCounts);
                }
            }
        }

        Collections.sort(houseCountsPerCluster);
        System.out.println(houseCountsPerCluster.size());
        houseCountsPerCluster.forEach(System.out::println);

        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + vertical[i];
            int nextY = y + horizontal[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                if (graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                    clusterCounts++;
                }
            }
        }
    }
}
