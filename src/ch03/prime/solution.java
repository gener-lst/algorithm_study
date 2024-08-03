package ch03.prime;
import java.util.ArrayList;

class Solution {
    public static boolean[] visited;
    public static ArrayList<Integer> ans;
    public int solution(String numbers) {
        visited = new boolean[7];
        ans = new ArrayList<>();
        int answer = 0;

        dfs(0, numbers, "");

        System.out.println(ans);

        for (Integer num : ans) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int depth, String numbers, String s) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                int next = Integer.parseInt(s + numbers.charAt(i));
                if (!ans.contains(next)) {
                    ans.add(next);
                }
                dfs(depth + 1, numbers, s + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.solution("011");
        System.out.println(ans);
    }
}