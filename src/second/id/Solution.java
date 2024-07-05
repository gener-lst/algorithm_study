package second.id;

public class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1. 대문자 소문자화
        new_id = new_id.toLowerCase();
        // 2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자열 제외
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                answer += ch;
            }
        }
        // 3. 마침표가 2번 이상 연속된 부분을 마침표 하나로 치환
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        System.out.println(answer);
        // 4. 마침표가 처음이나 끝에 위치하면 제거
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        System.out.println(answer);
        // 5. 빈 문자열일 경우, a 대입
        if (answer.isEmpty()) {
            answer = "a";
        }
        // 6. new_id가 16자 이상이면 15개 문자를 제외한 나머지 문자 제거.
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            System.out.println(answer);
            // 마침표가 끝에 위치하는지 확인
            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        // 7. 길이가 2자 이하면 아이디의 마지막 문자를 총 길이 3까지 추가
        while(answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String given = "...!@BaT#*..y.abcdefghijklm";
        String result = s.solution(given);
        System.out.println(result);
    }
}
