package first.budget;

import java.util.Arrays;

public class Answer {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] > budget) {
                break;
            }
            sum += d[i];
            count++;
        }

        return count;
    }
}