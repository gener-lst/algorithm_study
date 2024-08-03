package ch01.twoSum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = {};

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer = new int[]{i, j};
                }
            }
        }

        return answer;
    }
}
