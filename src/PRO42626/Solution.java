package PRO42626;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int a : scoville) {
            pq.add(a);
        }

        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int n = pq.poll();
            int n2 = pq.poll();
            pq.add(n + (n2 * 2));
            answer++;
        }
        return answer;
    }
}