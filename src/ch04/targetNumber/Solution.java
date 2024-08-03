package ch04.targetNumber;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0,  target,0);
    }

    private int dfs(int[] numbers, int index, int target, int sum) {
        if(index == numbers.length) {
            return (target == sum) ? 1 : 0;
        }

        int count = 0;
        count += dfs(numbers, index + 1, target, sum + numbers[index]);
        count += dfs(numbers, index + 1, target, sum - numbers[index]);

        return count;
    }
}