package ch04.wordConvert;

import java.util.*;

public class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean targetExists = false;
        for(String word : words) {
            if(word.equals(target)) {
                targetExists = true;
                break;
            }
        }
        if(!targetExists) return 0;

        return bfs(begin, words, target);
    }

    private int bfs(String begin, String[] words, String target) {
        Queue<Object[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Object[]{begin, 0});
        visited.add(begin);

        while(!queue.isEmpty()) {
            Object[] cur = queue.poll();
            String curr = (String) cur[0];
            int count = (int) cur[1];

            if(curr.equals(target)) return count;

            char[] chars = curr.toCharArray();
            for (String word : words) {
                if (!visited.contains(word)) {
                    int dif = 0;
                    char[] temp = word.toCharArray();
                    for(int i = 0; i < chars.length; i++) {
                        if(chars[i] != temp[i]) {
                            dif += 1;
                            if(dif > 1) break;
                        }
                    }
                    if(dif == 1) {
                        queue.offer(new Object[]{word, count + 1});
                        visited.add(word);
                    }
                }
            }
        }
        return 0;
    }
}

