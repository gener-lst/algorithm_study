package ch04.coin;

import java.util.*;

class Answer2 {
    public int coinChange(int[] coins, int amount) {
        //✅ amount가 0이면, 0을 반환한다. (예외 처리)
        if (amount == 0) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount + 1];
        //✅ 초기 금액을 amount, 동전 개수를 0으로 설정하고, 큐에 추가한다.
        queue.add(new int[]{amount, 0});
        //✅ 큐가 빌 때까지 반복문을 수행한다.
        while (!queue.isEmpty()) {
            //✅ 큐에서 현재 남은 금액과 현재 동전 개수를 remove한다.
            int[] cur = queue.remove();
            //✅ 한 동전을 사용해서 다음 남은 금액을 만든다.
            for (int i = 0; i < coins.length; i++) {
                int nextAmount = cur[0] - coins[i];
                //✅ 다음 남은 금액이 0이면, 현재 동전 개수에 1을 더해서 반환한다.
                if (nextAmount == 0) {
                    return cur[1] + 1;
                    //✅ 다음 남은 금액이 0보다 크고, 다음 남은 금액이 처음 발생하면,
                } else if (nextAmount > 0 && !visited[nextAmount]) {
                    //✅ 다음 남은 금액과 동전 개수에 1을 더해서 큐에 추가한다.
                    queue.add(new int[]{nextAmount, cur[1] + 1});
                    //✅ visited에서 다음 남은 금액에 대해 true로 처리한다.
                    visited[nextAmount] = true;
                }
            }
        }
        //✅ coins의 동전으로 amount를 만들 수 없다면 -1을 반환한다.
        return -1;
    }
}