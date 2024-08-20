package ch08.disk;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparing(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));

        int currentTime = 0;
        int count = 0;
        int totalTime = 0;
        int jobIndex = 0;

        while (count < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }

            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                currentTime += cur[1];
                count ++;
                totalTime += currentTime - cur[0];
            } else {
                currentTime = jobs[jobIndex][0];
            }
        }

        return totalTime / count;
    }
}
