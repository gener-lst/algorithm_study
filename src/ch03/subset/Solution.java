package ch03.subset;

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    private void backTrack(int index, List<Integer> subset, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backTrack(i + 1, subset, nums, ans);
            subset.remove(subset.size() - 1);
        }
    }
}
