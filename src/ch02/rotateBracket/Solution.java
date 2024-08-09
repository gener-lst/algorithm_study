package ch02.rotateBracket;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isValid(s)) answer += 1;
            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if ((stack.peek() == '(' && ch == ')') ||
                    (stack.peek() == '[' && ch == ']') ||
                    (stack.peek() == '{' && ch == '}')) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int sol = s.solution("[](){}");
        System.out.println(sol);
    }
}
