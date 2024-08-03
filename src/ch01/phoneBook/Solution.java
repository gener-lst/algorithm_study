package ch01.phoneBook;

public class Solution {
    public boolean solution(String[] phone_book) {
//        배열 내의 i에 대해 그 이후의 인덱스 번호를 각각 비교
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
//                먼저, 첫 글자가 같은지 비교(같지 않다면, 비교하는 의미 없으므로 효율성을 위해)
                if (phone_book[i].charAt(0) == phone_book[j].charAt(0)) {
//                  이후 비교할 두 번호에 대해 길이 비교 후 더 짧은 번호가 긴 번호의 접두어에 해당하는지 확인
                    if (phone_book[i].length() >= phone_book[j].length()) {
                        if(phone_book[i].startsWith(phone_book[j]))
                            return false;
                    } else if (phone_book[i].length() < phone_book[j].length()) {
                        if(phone_book[j].startsWith(phone_book[i]))
                            return false;
                    }
                }
            }
        }
        return true;
    }
//    효율성에서 떨어져 버렸다...
}
