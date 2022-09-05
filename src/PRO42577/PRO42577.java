package PRO42577;

import java.util.HashSet;

public class PRO42577 {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                hs.add(phone_book[i].substring(0, j));
            }
        }

        for (int i = 0; i < phone_book.length; i++) {
            if (hs.contains(phone_book[i])) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        solution(new String[]{"123", "456", "789"});
    }
}
