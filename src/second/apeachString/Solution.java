package second.apeachString;

public class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int cut = 1; cut <= s.length() / 2; cut++) { // 문자열 길이의 절반까지만 순회
            String compressed = "";
            String prevPart = s.substring(0, cut); // 반복 여부를 비교할 문자열
            int count = 1; // 연속된 문자열의 개수

            for (int i = cut; i < s.length(); i += cut) {
                String part;
                // 루프 내에서 정해진 자릿수로 잘라서 prevPart와 비교할 문자열 저장
                if (i + cut <= s.length()) {
                    part = s.substring(i, i + cut);
                } else {
                    part = s.substring(i); // 마지막 부분 문자열
                }
                // 비교 문자열 간 같으면 count 증가
                if (prevPart.equals(part)) {
                    count++;
                    // 아닐 경우에 count가 2 이상이라면 압축된 문자열을 저장
                    // 1이라면 문자열 그대로 저장하고 prevPart 갱신
                } else {
                    if (count > 1) {
                        compressed += count + prevPart;
                    } else {
                        compressed += prevPart;
                    }
                    prevPart = part; // 이전 부분 문자열 업데이트
                    count = 1; // count 다시 초기화
                }
            }
            // 마지막 부분 문자열 처리
            if (count > 1) {
                compressed += count + prevPart;
            } else {
                compressed += prevPart;
            }
            if(compressed.length() < answer) {
                answer = compressed.length();
            }
        }
        return answer;
    }
}
