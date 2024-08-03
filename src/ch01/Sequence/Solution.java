package ch01.Sequence;

public class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum;
        int[] answer = {5, 1000000};
        for (int i = 0; i < sequence.length; i++) {
            sum = 0;
            for (int j = i; j < sequence.length; j++) {
                sum += sequence[j];
                if (sum == k) {
                    if (j - i < answer[1] - answer[0]) {
                        answer[0] = i;
                        answer[1] = j;
                    }
                } else if (sum > k) {
                    break;
                }
            }
        }
        return answer;
    }
}
