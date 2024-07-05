package second.functionDevelopment;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] due = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            due[i] = (int) Math.ceil(100 - progresses[i]) / speeds[i];
        }
        for(int i = 0; i < progresses.length; i++){
            for(int j = i + 1; j < progresses.length; j++){
                if(due[j] > due[i]){}
            }
        }
        return answer;
    }
}

