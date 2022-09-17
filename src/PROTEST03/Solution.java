package PROTEST03;

import java.util.Arrays;

public class Solution {
    static boolean[][] memory;
    static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int M;
    static int[][] field;
    public static int solution(int N, int[][] mine, int[] P) {
        memory = new boolean[N+1][N+1];
        field = new int[N+1][N+1];
        Arrays.fill(memory[0], true);
        Arrays.fill(field[0], -1);
        for(int i = 0; i <= N; i++) {
            memory[i][0] = true;
            field[i][0] = -1;
        }

        M = N;

        for(int[] point : mine) {
            memory[point[0]][point[1]] = true;
            for (int i = 0; i < 8; i++) {
                int newY = point[0] + dy[i];
                int newX = point[1] + dx[i];
                if (newY < 1 || newX < 1 || newY > M || newX > M || memory[newY][newX]) {
                    continue;
                }

                field[newY][newX]++;
            }
        }
        memory[P[0]][P[1]] = true;
        int answer = recursive(mine, new int[] {P[0], P[1]}) + 1;
        return answer;
    }

    public static int recursive(int[][] mine, int[] P) {
        int result = 0;

        for(int i = 0 ; i < 8; i++) {
            int newY = P[0] + dy[i];
            int newX = P[1] + dx[i];
            if(newY < 1 || newX < 1 || newY > M || newX > M || memory[newY][newX]) {
                continue;
            }
            memory[newY][newX] = true;

            if(field[newY][newX] > 0) {
                result++;
            } else {
                result += recursive(mine, new int[] {newY, newX}) + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][] {{1, 2}, {2, 6}, {3, 4}, {3, 8}, {4, 9}, {5, 4}, {5, 8}, {6, 7}, {7, 2}, {9, 1}}, new int[] {8, 5}));
        System.out.println(solution(3, new int[][] {{2,2}}, new int[] {1, 1}));
    }
}

