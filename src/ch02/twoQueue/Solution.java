package ch02.twoQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

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

        int maxOperations = 4 * n; // 최대 연산 횟수
        int operations = 0;

        while (operations < maxOperations) {
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
                return operations;
            }
            operations++;
        }
        return -1;
    }
}
