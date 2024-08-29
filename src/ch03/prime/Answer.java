package ch03.prime;

import java.util.*;

class Answer {
    public int solution(String numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        dfs(0, numbers, "", new boolean[numbers.length()], uniqueNumbers);

        int answer = 0;
        for (Integer num : uniqueNumbers) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int depth, String numbers, String s, boolean[] visited, Set<Integer> uniqueNumbers) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                uniqueNumbers.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(depth + 1, numbers, s + numbers.charAt(i), visited, uniqueNumbers);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
