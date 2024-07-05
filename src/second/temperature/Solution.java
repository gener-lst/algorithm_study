package second.temperature;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] temps) {
        int[] ans = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        for (int day = 0; day < temps.length; day++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[day]) {
                int prevDay = stack.pop();
                ans[prevDay] = day - prevDay;
            }
            stack.push(day);
        }
        return ans;
    }
}
