package ch01.phoneBook;

import java.util.Arrays;

public class Answer {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
//          정렬이 되어있으므로 이중 for문이 필요하지 않음!
            if (phone_book[i+1].startsWith(phone_book[i]))
                return false;
        }

        return true;
    }
}
