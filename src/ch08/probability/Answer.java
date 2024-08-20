package ch08.probability;

import java.util.*;

class Answer {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
        }

        // PriorityQueue to maximize probability
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getProb).reversed());
        pq.add(new Edge(start_node, 1.0));

        double[] probs = new double[n];
        probs[start_node] = 1.0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int node = cur.node;
            double prob = cur.prob;

            if (node == end_node) {
                return prob;  // 최대 확률이므로 바로 반환
            }

            for (Edge e : graph.get(node)) {
                double newProb = prob * e.prob;
                if (newProb > probs[e.node]) {
                    probs[e.node] = newProb;
                    pq.add(new Edge(e.node, newProb));
                }
            }
        }

        return 0.0;  // 도달할 수 없는 경우
    }
}