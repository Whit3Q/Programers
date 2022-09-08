package PRO42748;

import java.util.Arrays;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int resultIndex = 0;
        for(int y = 0 ; y < commands.length; y++) {
            int size = commands[y][1] - commands[y][0]+1;
            int[] arr = new int[size];
            int index = 0;
            for(int i = commands[y][0]-1; i < commands[y][1]; i++,index++) {
                arr[index] = array[i];
            }
            Arrays.sort(arr);
            answer[resultIndex] = arr[commands[y][2]-1];
            resultIndex++;
        }

        return answer;
    }

    public static void main(String[] args) {
        for(int n :solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})) {
            System.out.println(n);
        }
    }
}