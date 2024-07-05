package first.phoneBook;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[i].length() > phone_book[j].length()) {
                    phone_book[i].indexOf(phone_book[j], 0);
                } else if(phone_book[i].length() < phone_book[j].length()) {

                }
            }
        }
        return true;
    }
}
