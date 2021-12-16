package baekjoon.dfs_bfs.p1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int[] DIRECTION_X = {1, -1, 0, 0};
    private static final int[] DIRECTION_Y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCounts = Integer.parseInt(br.readLine());
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < testCaseCounts; i ++) {
            String[] input = br.readLine().split(" ");
            int xSize = Integer.parseInt(input[0]);
            int ySize = Integer.parseInt(input[1]);
            int cabbageCounts = Integer.parseInt(input[2]);
            int[][] map = new int[xSize][ySize];
            boolean[][] visited = new boolean[xSize][ySize];

            for (int j = 0; j < cabbageCounts; j++) {
                String[] coordinateInput = br.readLine().split(" ");
                map[Integer.parseInt(coordinateInput[0])][Integer.parseInt(coordinateInput[1])] = 1;
            }

            int wormCounts = 0;

            for (int x = 0; x < xSize; x++) {
                for (int y = 0; y < ySize; y++) {
                    if (map[x][y] == 1 && !visited[x][y]) {
                        dfs(xSize, ySize, x, y, map, visited);
                        wormCounts++;
                    }
                }
            }

            answers.add(wormCounts);
        }

        answers.forEach(System.out::println);

        br.close();
    }

    private static void dfs(int xSize, int ySize, int x, int y, int[][] map, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + DIRECTION_X[i];
            int newY = y + DIRECTION_Y[i];
            if (newX >= 0 && newX < xSize && newY >= 0 && newY < ySize) {
                if (map[newX][newY] == 1 && !visited[newX][newY]) {
                    dfs(xSize, ySize, newX, newY, map, visited);
                }
            }
        }
    }
}
