package ch03.permutations;

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, visited, ans);
        return ans;
    }

    private void backtrack(List<Integer> curr, int[] nums, boolean[] visited, List<List<Integer>> ans) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;

            curr.add(nums[i]);
            visited[i] = true;

            backtrack(curr, nums, visited, ans);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}