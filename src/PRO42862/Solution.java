package PRO42862;

import java.util.ArrayList;

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {


        int[] list = new int[n + 1];
        boolean[] memory = new boolean[n + 1];
        ArrayList<Integer> losts = new ArrayList<>();
        for (int i = 0; i < reserve.length; i++) {
            memory[reserve[i]] = true;
        }
        for(int i = 0 ; i < lost.length; i++) {
            if(memory[lost[i]]) {
                memory[lost[i]] = false;
            } else {
                losts.add(lost[i]);
            }
        }
        int result = n - losts.size();
        result += dfs(losts.stream().mapToInt(i -> i).toArray(), memory, 0);

        return result;
    }

    public static int dfs(int[] lost, boolean[] memory, int index) {
        if (index > lost.length - 1) {
            return 0;
        }

        int result = 0;

        if (memory[lost[index] - 1]) {
            memory[lost[index] - 1] = false;
            result = Math.max(result, dfs(lost, memory, index + 1) + 1);
            memory[lost[index] - 1] = true;
        }

        if (lost[index] + 1 < memory.length && memory[lost[index] + 1]) {
            memory[lost[index] + 1] = false;
            result = Math.max(result, dfs(lost, memory, index + 1) + 1);
            memory[lost[index] + 1] = true;
        }


        return Math.max(result, dfs(lost, memory, index + 1));
    }

    public static void main(String[] args) {
//        System.out.println(solution(5, new int[]{2, 1,4}, new int[]{1, 3, 5}));
//        System.out.println(solution(7, new int[]{2,4,7}, new int[]{1, 3, 5}));
//        System.out.println(solution(5, new int[]{1,2,4,5}, new int[]{2, 3, 4}));
//        System.out.println(solution(3, new int[]{1,2}, new int[]{2, 3}));
        System.out.println(solution(13, new int[]{1, 2, 5, 6, 10, 12, 13}, new int[]{2, 3, 4, 5, 7, 8, 9, 10, 11, 12}));
    }
}