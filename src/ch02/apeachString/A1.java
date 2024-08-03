package ch02.apeachString;

public class A1 {
    public int solution(String s) {
//      문제를 잘못 이해함 -> 내부에서 반복되는 문자열에 대해 중복 부분이 몇 번 반복되는지로 압축하는 것으로 최초에 풀었음
        int minLength = s.length();
        int n = s.length();

        for (int start = 0; start < n / 2; start++) {
            int end = start + 1;
            while (end <= n) {
                String substring = s.substring(start, end);
                int count = countIndex(substring, s);

                // 축소된 길이 계산
                int reducedLength = n - (substring.length() * (count - 1)) + 1;
                // 최소 길이 갱신
                if (reducedLength < minLength) {
                    minLength = reducedLength;
                }

                end++;
            }
        }

        return minLength;
    }

    public static int countIndex(String word, String s) {
        int count = 0;
        int index = s.indexOf(word);
        while (index != -1) {
            count++;
            index = s.indexOf(word, index + 1);
        }
        return count;
    }
}
