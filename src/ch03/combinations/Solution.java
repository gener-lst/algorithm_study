package ch03.combinations;

import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    public void backTrack(List<List<Integer>> result, ArrayList<Integer> set, int start, int n, int k) {
        if(set.size() == k) {
            result.add(new ArrayList(set));
        }

        for(int i = start; i <= n && set.size() < k; i++) {
            set.add(i);
            backTrack(result, set, i + 1, n, k);
            set.remove(set.size() - 1);
        }
    }
}