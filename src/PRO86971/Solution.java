package PRO86971;

class Solution {
    public static int solution(int n, int[][] wires) {
        boolean[][] link = new boolean[n+1][n+1];
        for(int[] arr: wires) {
            link[arr[0]][arr[1]] = true;
            link[arr[1]][arr[0]] = true;
        }
        int result = Integer.MAX_VALUE;
        for(int y = 1; y < n+1; y++) {
            for(int x = 1; x < n+1; x++) {
                if(link[y][x]) {
                    int tmp1 = 0;
                    int tmp2 = 0;
                    link[y][x] = false;
                    link[x][y] = false;
                    tmp1 = dfs(link, new boolean[n+1], y);
                    tmp2 = dfs(link, new boolean[n+1], x);
                    result = Math.min(result, Math.abs(tmp1 - tmp2));
                    link[y][x] = true;
                    link[x][y] = true;
                }
            }
        }

        return result;
    }

    public static int dfs(boolean[][] link, boolean[] memory ,int nod) {
        int result = 1;
        memory[nod] = true;
        for(int i = 1; i < link.length; i++) {
            if(!link[nod][i] || memory[i]) {
                continue;
            }
            result += dfs(link, memory, i);
        }
        memory[nod] = false;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }
}