package ch02.stockPrice;

import java.util.*;

// 스택을 이용한 풀이
class Solution2 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (prices[j] > prices[i]) {
                    answer[j] = i - j;
                    stack.pop();
                }
                else break;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int i = stack.pop();
            answer[i] = prices.length - i - 1;
        }

        return answer;
    }
}
