package first.Sequence;

class Answer {
    public int[] solution(int[] sequence, int k) {
        //✅ 정답 범위의 초기값을 (0, 1,000,000)으로 설정한다.
        int[] answer = {0, 1_000_000};

        int total = 0;
        int start = 0;

        //✅ end를 0 ~ sequence.length - 1 까지 순회한다.
        for (int end = 0; end < sequence.length; end++) {
            //✅ end 부분을 합계에 더한다.
            total += sequence[end];

            //✅ 합계가 k보다 작거나 같을때까지 start를 증가시킨다.
            while (total > k) {
                total -= sequence[start];
                start++;
            }

            //✅ 합계가 k와 같고, 현재 윈도우가 우선순위가 더 높다면 정답을 현재 범위로 바꾼다.
            if (total == k) {
                if ((end - start) < (answer[1] - answer[0])) {
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
        //✅ 정답을 반환한다.
        return answer;
    }
}
