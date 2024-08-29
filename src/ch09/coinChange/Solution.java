package ch09.coinChange;

import java.util.*;

class Solution {
    public int solution(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < amount; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int coin : coins) {
                if (i + coin <= amount) {
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}
