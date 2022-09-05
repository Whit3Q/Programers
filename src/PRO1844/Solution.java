package PRO1844;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int Y;
    static int X;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static boolean[][] memory;

    public int solution(int[][] maps) {
        Y = maps.length;
        X = maps[0].length;
        memory = new boolean[Y][X];
        return bfs(new Point(0,0), maps);
    }

    public int bfs(Point start, int[][] maps) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(start);
        int count = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            count++;

            while (size-- > 0) {
                Point prePoint = queue.remove();

                for (int i = 0; i < 4; i++) {
                    int newY = prePoint.y + dy[i];
                    int newX = prePoint.x + dx[i];
                    if (newY == Y - 1 && newX == X - 1) {
                        return count + 1;
                    }
                    if (newY < 0 || newY >= Y || newX < 0 || newX >= X || maps[newY][newX] == 0) {
                        continue;
                    }

                    queue.add(new Point(newY, newX));
                    maps[newY][newX] = 0;
                }
            }
        }
        return -1;
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public void Main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1},{1, 0, 1, 0, 1},{1, 0, 1, 1, 1},{1, 1, 1, 0, 1},{0, 0, 0, 0, 1}};
        Solution s = new Solution();
        System.out.println(s.solution(maps));

    }
}