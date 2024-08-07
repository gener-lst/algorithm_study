package ch04.coin;

import java.util.*;

public class Answer {
    public int coinChange(int[] coins, int amount) {
        //dp[amount]가 정답이므로 amount + 1의 크기로 초기화
        int[] dp = new int[amount + 1];

        //최소값을 찾는 것이므로 무한대에 해당하는 값을 채우기
        //점화식 dp[i - coin] + 1으로 인해 overflow를 해결하기 위해 - 1
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        //0을 만드는데 필요한 경우의 수를 첫번째 값에 초기화
        dp[0] = 0;

        //dp 배열의 2번째부터 돌면서
        for (int i = 1; i < dp.length; i++) {
            //모든 동전 중에
            for (int coin : coins) {
                //해당 값이 coin보다 작으면 사용하지 않음. (e.g. 3원을 만들때 5원짜리 동전)
                if (i >= coin)

                    //dp[i] == 기존에 존재하던 i를 만드는 경우의 수 중 최소값
                    //dp[i - coin] == i - coin이라는 값을 만드는 모든 경우의 수 + 1(var coin이라는 하나의 경우의 수가 추가되므로)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        //dp[amount]에 도달한 적이 없으면 -1
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
