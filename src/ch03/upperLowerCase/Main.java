package ch03.upperLowerCase;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length() ; i++) {
//            * case 1
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                answer.append(Character.toLowerCase(s.charAt(i)));
            } else if(s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                answer.append(Character.toUpperCase(s.charAt(i)));
            }

//            * case 2
//            if(Character.isUpperCase(s.charAt(i))) answer.append(Character.toLowerCase(s.charAt(i)));
//            else answer.append(Character.toUpperCase(s.charAt(i)));

//            * case 3
//            if('a'<=s.charAt(i)&&s.charAt(i)<='z'){
//                answer.append(('A' + (s.charAt(i) - 'a')));
//            }
//            else{
//                answer.append(('a' + (s.charAt(i) - 'A')));
//            }
        }
        System.out.println(answer);
    }
}