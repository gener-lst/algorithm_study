package first.budget;

import java.util.Vector;

public class Budget {
    int solution(Vector<Integer> d, int budget) {
        int sum = 0;
        int count = 0;

        for(int i = 0; i < d.size() - 1; i++) {
            for (int j = i + 1; j < d.size(); j++) {
                if(d.get(i) > d.get(j)) {
                    d.add(j, d.get(i));
                    d.remove(i);
                }
            }
        }

        for (int i = 0; i < d.size(); i++) {
            if(sum > budget) {
                break;
            }
            sum += d.get(i);
            count++;
        }

        return count;
    }
}
