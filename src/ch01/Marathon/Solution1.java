package ch01.Marathon;

import java.util.Arrays;

public class Solution1 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
//            System.out.println(participant[i]);
//            System.out.println(completion[i]);
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }

//    public static void main(String[] args) {
//        Solution1 solution = new Solution1();
//        String answer = solution.solution(new String[] {"mislav", "stanko", "mislav", "ana"},new String[] {"stanko", "ana", "mislav"});
//        System.out.println(answer);
//    }
}