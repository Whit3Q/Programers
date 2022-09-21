package PRO87946;

class Solution {
    public static int solution(int k, int[][] dungeons) {
        boolean[] memory = new boolean[dungeons.length];
        return dfs(dungeons, memory, k);
    }

    public static int dfs(int[][] dungeons, boolean[] memory, int k) {
        int result = 0;
        for(int i = 0; i < dungeons.length; i++) {
            if(memory[i] || k < dungeons[i][0]) {
                continue;
            }
            memory[i] = true;
            result += Math.max(result,dfs(dungeons, memory, k-dungeons[i][1])+1);
            memory[i] = false;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][] {{80, 20},{50, 40},{30, 10}}));
    }
}