package PROTEST01;

public class Solution {
    public static String solution(String src) {
        StringBuilder sb = new StringBuilder();

        int check = 1;
        if(src.charAt(0) - 48 == 1) {
            sb.append("1");
        } else {
            sb.append("0");
            check = 0;
        }
        int count = 0;
        for(int i = 1; i < src.length(); i++) {
            int tmp = src.charAt(i) - 48;
            if(tmp == check) {
                count++;
            } else {
                check = tmp;
                sb.append((char) (count+65));
                count = 0;
            }
        }
        sb.append((char) (count+65));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("11111"));
    }
}
