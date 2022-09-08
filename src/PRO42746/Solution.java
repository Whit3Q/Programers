package PRO42746;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    //{6, 10, 2}
    //{3, 30, 34, 5, 9}
    public static String solution(int[] numbers) {

        if(Arrays.stream(numbers).sum() == 0) {
            return "0";
        }

//        1번 풀이
//        String[] strs = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2+o1).compareTo(o1+o2);
//            }
//        });

//        2번풀이 1번을 람다식 변환
//        String[] strs = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
//        Arrays.sort(strs, (o1, o2) -> (o2+o1).compareTo(o1+o2));

//        return String.join("", strs);
        return Arrays.stream(numbers).mapToObj(String::valueOf).sorted((o1,o2)-> (o2+o1).compareTo(o1+o2)).collect(Collectors.joining(""));
    }



    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
    }
}
