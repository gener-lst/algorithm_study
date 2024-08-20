package ch08.probability;

import java.util.*;

class Edge {
    int node;
    double prob;

    public Edge(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }

    public double getProb() {
        return prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i <= edges.length; i++) {
            graph.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getProb).reversed());
        pq.add(new Edge(start_node,1));
        double maxProbability = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int node = cur.node;
            double prob = cur.prob;

            if(node == end_node) {
                maxProbability = Math.max(maxProbability, prob);

            }

            for (Edge e : graph.get(node)) {
                if (prob * e.prob > maxProbability) {
                    maxProbability = prob * e.prob;
                    pq.add(new Edge(e.node, maxProbability));
                }
            }
        }

        return maxProbability;
    }
}