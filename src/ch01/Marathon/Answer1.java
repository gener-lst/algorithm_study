package ch01.Marathon;

import java.util.Arrays;

public class Answer1 {
    public String solution(String[] participant, String[] completion) {
        // 정렬 - O(nlogn)
        Arrays.sort(participant);
        Arrays.sort(completion);

        // i 0~n-1 순회 -> O(n)
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }
}
// 시간 복잡도 = m x n log n