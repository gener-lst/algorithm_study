package first.Marathon;

public class Solution2 {
    static String[] a1 = { "marina", "josipa", "nikola", "vinko", "filipa"};
    static String[] a2 = { "josipa", "filipa", "marina", "nikola"};
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        int count = 0;

        for(int i = 0; i < participant.length; i++) {
            for(int j = 0; j < completion.length; j++) {
                if(participant[i].equals(completion[j])) {
                    count++;
                    break;
                }
            }
            if(i > count) {
                return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(a1, a2);
    }
}
