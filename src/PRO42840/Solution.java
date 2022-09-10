package PRO42840;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static int[] solution(int[] answers) {

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] count = new int[4];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%one.length]) {
                count[1]++;
            }
            if(answers[i] == two[i%two.length]) {
                count[2]++;
            }
            if(answers[i] == three[i%three.length]) {
                count[3]++;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        int maxIndex = 1;
        for(int i = 1; i <= 3; i++) {
            if(count[maxIndex] < count[i]) {
                result = new ArrayList<>();
                maxIndex = i;
                result.add(i);
            } else if(count[maxIndex] == count[i]){
                result.add(i);
            }
        }

        Collections.sort(result);
//        int[] re = new int[result.size()];
//        for(int i = 0; i < result.size(); i++) {
//            re[i] = result.get(i);
//        }
//
//        return re;
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] re = solution(new int[] {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 2});

        for(int i : re) {
            System.out.println(i);
        }
    }
}