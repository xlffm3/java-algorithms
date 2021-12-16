package baekjoon.dfs_bfs.p2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final int[] DIRECTION_X = {1, -1, 0, 0};
    private static final int[] DIRECTION_Y = {0, 0, 1, -1};
    private static int houseCounts = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] inputArray = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < inputArray.length; j++) {
                map[i][j] = inputArray[j] - '0';
                visited[i][j] = false;
            }
        }

        List<Integer> houseCountsPerChunk = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    houseCounts = 1;
                    dfs(n, i, j, map, visited);
                    houseCountsPerChunk.add(houseCounts);
                }
            }
        }

        Collections.sort(houseCountsPerChunk);
        System.out.println(houseCountsPerChunk.size());
        houseCountsPerChunk.forEach(System.out::println);

        bufferedReader.close();
    }

    private static void dfs(int n, int x, int y, int[][] map, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DIRECTION_X[i];
            int nextY = y + DIRECTION_Y[i];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(n, nextX, nextY, map, visited);
                    houseCounts++;
                }
            }
        }
    }
}
