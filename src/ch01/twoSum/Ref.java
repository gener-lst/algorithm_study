package ch01.twoSum;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ref {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        int q1sum = 0;
        int q2sum = 0;

        for (int value : queue1) {
            q1.add(value);
            q1sum += value;
        }

        for (int value : queue2) {
            q2.add(value);
            q2sum += value;
        }

        for (int i = 0; i < 4 * n; i++) {
            if (q1sum > q2sum) {
                int value = q1.remove();
                q2.add(value);
                q1sum -= value;
                q2sum += value;
            } else if (q1sum < q2sum) {
                int value = q2.remove();
                q1.add(value);
                q2sum -= value;
                q1sum += value;
            } else {
                return i;
            }
        }
        return -1;
    }
}

