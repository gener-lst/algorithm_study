package second.bracket;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
//        속도 최적화를 위해 stack 대신 deque를 사용하는 것을 추천 -> 공식문서에도 명시됨

        if(s.charAt(s.length()-1) == '(') return false;
//      최적화(루프 끝까지 돌 필요 없이 끝내는 조건문)
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        answer = stack.isEmpty();

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "(())()";
        boolean result = s.solution(s1);
        System.out.println(result);
    }
}
