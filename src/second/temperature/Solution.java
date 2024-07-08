package second.temperature;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] temps) {
        int[] sol = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                int takenTime = stack.pop();
                sol[takenTime] = i - takenTime;
            }
            stack.push(i);
        }
        return sol;
    }
}
