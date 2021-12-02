package baekjoon.dfs_bfs.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
                this.graph.add(new ArrayList<>());
                this.visited[i] = false;
            }
        }

        public void putBidirectional(int u, int v) {
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);
        }

        public void sort() {
            for (List<Integer> list : graph) {
                Collections.sort(list);
            }
        }

        public void searchDfs(int startNodeNumber) {
            visited[startNodeNumber] = true;
            System.out.print(startNodeNumber + " ");
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(startNodeNumber);

            while (!deque.isEmpty()) {
                int now = deque.peek();
                List<Integer> adjList = graph.get(now);
                boolean hasNearNode = false;

                for (Integer i : adjList) {
                    if (!visited[i]) {
                        visited[i] = true;
                        hasNearNode = true;
                        System.out.print(i + " ");
                        deque.push(i);
                        break;
                    }
                }

                if (!hasNearNode) {
                    deque.pop();
                }
            }
            System.out.println();
        }

        public void resetVisited() {
            for (int i = 0; i < this.visited.length + 1; i++) {
                this.visited[i] = false;
            }
        }

        public void searchBfs(int startNodeNumber) {
            visited[startNodeNumber] = true;
            System.out.print(startNodeNumber + " ");
            Deque<Integer> deque = new ArrayDeque<>();
            deque.offer(startNodeNumber);

            while (!deque.isEmpty()) {
                int now = deque.poll();
                List<Integer> adjList = graph.get(now);
                for (int i : adjList) {
                    if (!visited[i]) {
                        visited[i] = true;
                        System.out.print(i + " ");
                        deque.add(i);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLineInput = br.readLine().split(" ");
        int nodeCounts = Integer.parseInt(firstLineInput[0]);
        int edgeCounts = Integer.parseInt(firstLineInput[1]);
        int startNodeNumber = Integer.parseInt(firstLineInput[2]);

        Graph graph = new Graph(nodeCounts);
        for (int i = 0; i < edgeCounts; i++) {
            String[] nvInput = br.readLine().split(" ");
            graph.putBidirectional(Integer.parseInt(nvInput[0]), Integer.parseInt(nvInput[1]));
        }

        graph.sort();
        graph.searchDfs(startNodeNumber);
        graph.resetVisited();
        graph.searchBfs(startNodeNumber);

        br.close();
    }
}
