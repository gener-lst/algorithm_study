package first.Sequence;

import java.util.Arrays;

public class Sequence {
    public int[] solution(int[] sequence, int k) {
        Arrays.sort(sequence);
        int sum;
        int[] answer = new int[2];
        for(int i = 0; i < sequence.length; i++) {
            sum = 0;
            for(int j = i; j < sequence.length; j++) {
                sum += sequence[j];
                if(sum == k) {
                    answer[0] = i;
                    answer[1] = j;
                } else if (sum > k) {
                    break;
                }
            }
        }

        return answer;
    }
}
