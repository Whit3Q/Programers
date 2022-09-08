package PRO42747;

import java.util.Arrays;

class Solution {
    public static int solution(int[] citations) {
        int answer = 0;

//        Integer 만들어 풀기
//        Integer[] arr = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
//        int result = 0;
//        for(int i = 0; i < arr.length; i++) {
//            if(i+1 > arr[i]) {
//                return result;
//            }
//            result++;
//        }

        Arrays.sort(citations);
        int result = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(result+1 > citations[i]) {
                return result;
            }
            result++;
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}));
    }
}