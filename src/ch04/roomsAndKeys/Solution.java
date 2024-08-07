package ch04.roomsAndKeys;

import java.util.*;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            visited.add(false);
        }
        dfs(visited, rooms, 0);

        for (boolean isVisited : visited) {
            if (!isVisited) return false;
        }
        return true;
    }

    private void dfs(List<Boolean> visited, List<List<Integer>> rooms, int index) {
        visited.set(index, true);
        for(int i : rooms.get(index)) {
            if(!visited.get(i)) {
                dfs(visited, rooms, i);
            }
        }
    }
}

