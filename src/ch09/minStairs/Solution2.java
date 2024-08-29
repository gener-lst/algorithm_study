package ch09.minStairs;

import java.util.*;

class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(memo, cost, n);
    }

    public int dp(int[] memo, int[] cost, int n ){
        if(n == 0 || n == 1){
            return 0;
        }
        else if(memo[n] == -1){
            memo[n] = Math.min(dp(memo, cost, n - 1) + cost[n - 1],  dp(memo, cost, n - 2) + cost[n - 2]);
        }
        return memo[n];
    }
}