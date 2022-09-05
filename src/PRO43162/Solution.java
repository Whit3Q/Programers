package PRO43162;

/*
n	computers	                      return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */


public class Solution {
    static boolean[] memory;
    public int solution(int n, int[][] computers) {
        memory = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(memory[i]) {
                continue;
            }
            dfs(n, i, computers);
            count++;
        }
        return count;
    }

    public void dfs(int n, int index, int[][] computers) {
        if(index > n) {
            return;
        }
        memory[index] = true;

        for(int i = 0; i < n; i++) {
            if(computers[index][i] == 1 && !memory[i]) {
                dfs(n,i, computers);
            }
        }
    }
}
