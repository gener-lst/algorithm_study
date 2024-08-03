package ch01.budget;

import java.util.Arrays;

public class Answer2 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int result = 0;
        int price = 0;

        for(int i=0; i<d.length; i++){
            price = d[i];
            budget -= price;
            if(budget < 0){
                break;
            }
            result ++;
        }
        return result;
    }
}

