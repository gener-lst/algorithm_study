package ch01.Marathon;

import java.util.*;

class Answer2 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> counter = new HashMap<>();

        //✅ completion을 순회하며 해시테이블에 이름, 인원수를 저장한다.
        for (String p : completion) {
            counter.compute(p, (k, v) -> (v == null) ? 1 : v + 1);
        }

        //✅ participant를 순회한다.
        for (String p : participant) {
            //✅ 해시테이블에 저장되지 않았거나 인원이 0이 되었다면 이름을 반환한다.
            if (!counter.containsKey(p) || counter.get(p) == 0)
                return p;

            //✅ 인원수를 감소시킨다.
            counter.compute(p, (k, v) -> v - 1);
        }

        return null;
    }
}