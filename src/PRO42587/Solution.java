package PRO42587;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int[] count = new int[10];
        int[] preSum = new int[10];
        Queue<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            count[priorities[i]]++;
            queue.add(new Integer[] {priorities[i],i});
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += count[i];
            preSum[i] = sum;
        }
        int countNum = 0;
        while (!queue.isEmpty()) {

            Integer[] now = queue.poll();
            if (preSum[9] - preSum[now[0]] > 0) {
                queue.add(now);
                continue;
            } else {
                for (int i = now[0]; i < 10; i++) {
                    preSum[i]--;
                }
                countNum++;
                if(now[1] == location) {
                    return countNum;
                }
            }

        }
        return countNum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
    }
}