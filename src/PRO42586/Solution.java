package PRO42586;

import java.util.ArrayList;

/*
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */
class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int[] arr = new int[progresses.length];

        for (int i = 0; i < speeds.length; i++) {
            int tmp = 100 - progresses[i];
            if(tmp == 0) {
                arr[i] = 0;
                continue;
            }
            arr[i] = tmp / speeds[i];
            if (tmp % speeds[i] != 0) {
                arr[i]++;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int now = arr[0];
        int count = 1;
        int sum = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(now >= arr[i]) {
                count++;
                if(i == arr.length - 1) {
                    result.add(count);
                }
            } else {
                result.add(count);
                count = 1;
                now = arr[i];
                if(i == arr.length - 1) {
                    result.add(count);
                }
            }

        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        for(int i : solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})) {
            System.out.println(i);
        }
//        for(int i : solution(new int[] {95, 90, 99, 99, 99, 98}, new int[] {1, 1, 1, 1, 1, 1})) {
//            System.out.println(i);
//        }
    }
}