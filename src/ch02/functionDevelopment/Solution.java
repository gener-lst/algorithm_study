package ch02.functionDevelopment;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        // 전체 크기를 가변형으로 하기 위해 answer을 arrayList에 저장
        ArrayList<Integer> answer = new ArrayList<>();
        // 개별 작업당 걸리는 일수를 저장하는 배열
        int[] due = new int[progresses.length];
        // 개별 작업당 걸리는 일수를 계산
        for(int i = 0; i < progresses.length; i++){
            due[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int maxDue = due[0];
        int count = 0;
        // 개별 작업 일수를 계산한 배열을 for문으로 순차적으로 비교하여 순차적으로 배포되는 작업 개수 계산
        // 이 때, maxDue로 설정한 값을 순차enk적으로 비교하면서 더 많이 걸리는 작업의 일수로 이를 바꿈
        // 앞선 작업에 걸리는 기간보다 더 짧을 경우 작업 개수(count)를 1 올림
        for(int i = 0; i < progresses.length; i++){
            if(due[i] > maxDue) {
                answer.add(count);
                count = 1;
                maxDue = due[i];
            } else {
                count++;
            }
        }
        // 마지막 작업 묶음을 추가
        answer.add(count);
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        ArrayList answer = solution.solution(progresses, speeds);
        for(Object add : answer){
            System.out.println(add);
        }
    }
}

