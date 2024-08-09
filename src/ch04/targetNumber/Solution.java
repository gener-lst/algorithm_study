package ch04.targetNumber;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            return (target == sum) ? 1 : 0;
        }

        int count = 0;
        count += dfs(numbers, target, depth + 1, sum + numbers[depth]);
        count += dfs(numbers, target, depth + 1, sum - numbers[depth]);

        return count;
    }
}