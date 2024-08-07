package ch04.coin;

import java.util.*;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        // 초기 상태 추가
        for (int coin : coins) {
            if (coin == amount) return 1;
            if (coin < amount) {
                queue.offer(new int[]{coin, 1});
                visited.add(coin);
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int sum = temp[0];
            int count = temp[1];

            for (int coin : coins) {
                int newSum = sum + coin;
                if (newSum == amount) return count + 1;
                if (newSum < amount && !visited.contains(newSum)) {
                    queue.offer(new int[]{newSum, count + 1});
                    visited.add(newSum);
                }
            }
        }
        return -1;
    }
}
