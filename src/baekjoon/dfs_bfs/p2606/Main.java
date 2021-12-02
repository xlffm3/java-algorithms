package baekjoon.dfs_bfs.p2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    private static class Graph {

        private final List<List<Integer>> graph;
        private final boolean[] visited;

        public Graph(int nodeCounts) {
            this.graph = new ArrayList<>();
            this.visited = new boolean[nodeCounts + 1];
            for (int i = 0; i < nodeCounts + 1; i++) {
                graph.add(new ArrayList<>());
                visited[i] = false;
            }
        }

        public void putBidirectional(int n, int v) {
            graph.get(n).add(v);
            graph.get(v).add(n);
        }

        public int calculateInfectedComputerCounts() {
            int startNode = 1;
            int infectedComputerCounts = 0;
            visited[startNode] = true;
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(startNode);

            while (!deque.isEmpty()) {
                int currentNode = deque.peek();
                boolean hasNearNode = false;
                List<Integer> adjNodes = graph.get(currentNode);

                for (Integer i : adjNodes) {
                    if (!visited[i]) {
                        hasNearNode = true;
                        visited[i] = true;
                        deque.push(i);
                        infectedComputerCounts++;
                        break;
                    }
                }

                if (!hasNearNode) {
                    deque.pop();
                }
            }

            return infectedComputerCounts;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCounts = Integer.parseInt(br.readLine());
        int edgeCounts = Integer.parseInt(br.readLine());

        Graph graph = new Graph(computerCounts);
        for (int i = 0; i < edgeCounts; i++) {
            String[] nvInput = br.readLine().split(" ");
            graph.putBidirectional(Integer.parseInt(nvInput[0]), Integer.parseInt(nvInput[1]));
        }

        System.out.println(graph.calculateInfectedComputerCounts());
        br.close();
    }
}
