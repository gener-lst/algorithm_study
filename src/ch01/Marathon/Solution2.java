package ch01.Marathon;

import java.util.*;

public class Solution2 {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String name : completion) {
            map.compute(name, (k, v) -> (v == null) ? 1 : v + 1);
        }

        for (String name : participant) {
            if(map.containsKey(name) && map.get(name) > 0) {
                map.compute(name, (k, v) -> v - 1);
            } else {
                return name;
            }
        }
        return null;
    }
}
