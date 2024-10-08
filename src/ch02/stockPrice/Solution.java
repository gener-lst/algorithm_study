package ch02.stockPrice;

// 이중 for문 풀이
public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(new int[]{1, 2, 3, 2, 3});
        for(int i : answer) {
            System.out.println(answer[i]);
        }
    }
}
