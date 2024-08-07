package ch03.candidateKey;

import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int colLength;
    public static int rowLength;
    public static Set<String> list = new HashSet<>();
    public static List<String> list2 = new ArrayList<>();

    public int solution(String[][] relation) {
        colLength = relation[0].length;
        rowLength = relation.length;
        visited = new boolean[colLength];

        for (int i = 1; i <= colLength; i++) {
            combine(0, i, relation);
            validate(relation);
            list.clear();
        }

        return list2.size();
    }

    public void combine(int start, int combNum, String[][] relation) {
        if (combNum == 0) {
            String temp = "";
            for (int i = 0; i < colLength; i++) {
                if (visited[i]) {
                    temp += i;
                }
            }
            list.add(temp);
        }

        for (int i = start; i < colLength; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combine(start + 1, combNum - 1, relation);
                visited[i] = false;
            }
        }
    }

    public void validate(String[][] relation) {
        //유일성 판단하기
        for (String data : list) {
            String[] temp = data.split("");
            int[] arr = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                int c = Integer.parseInt(temp[i]);
                arr[i] = c;
            }
            //유일성 판단하기위한 set
            Set<String> set = new HashSet<>();
            for (int i = 0; i < rowLength; i++) {
                String cdd = "";
                for (String data2 : temp) {
                    int c = Integer.parseInt(data2);
                    cdd += relation[i][c];
                }
                set.add(cdd);
            }
            //만약 유일하다면 최소성 검사
            if (set.size() == rowLength) {
                boolean flag = false;
                for (String data3 : list2) {
                    int cnt = 0;
                    String[] temp3 = data3.split("");
                    for (String data4 : temp3) {
                        if (data.contains(data4)) {
                            cnt++;
                        }
                    }
                    if (cnt == data3.length()) {
                        flag = true;
                    }
                }
                if (!flag) {
                    list2.add(data);
                }
            }
        }
    }
}
