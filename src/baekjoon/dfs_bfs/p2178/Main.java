package baekjoon.dfs_bfs.p2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static final int[] DIRECTION_X = {1, -1, 0, 0};
    private static final int[] DIRECTION_Y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] graphSizes = br.readLine().split(" ");
        int n = Integer.parseInt(graphSizes[0]);
        int m = Integer.parseInt(graphSizes[1]);
        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < row.length; j++) {
                graph[i][j] = row[j] - '0';
                visited[i][j] = false;
            }
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = current.getX();
                int y = current.getY();
                int newX = x + DIRECTION_X[i];
                int newY = y + DIRECTION_Y[i];

                if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    if (graph[newX][newY] == 1 && !visited[newX][newY]) {
                        queue.offer(new Node(newX, newY));
                        visited[newX][newY] = true;
                        graph[newX][newY] = graph[x][y] + 1;
                    }
                }
            }
        }
        System.out.println(graph[n - 1][m - 1]);
        br.close();
    }

    private static class Node {

        private final int x;
        private final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
