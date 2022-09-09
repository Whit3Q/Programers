package PRO86491;

import java.util.Arrays;

class Solution {
    public static int solution(int[][] sizes) {
//        return dfs(sizes, 1, sizes[0][0], sizes[0][1]);
        return solve2(sizes);
    }

    public static int dfs(int[][] sizes, int index, int w, int h) {
        if(index == sizes.length) {
            return w * h;
        }

        int result = Integer.MAX_VALUE;
        int newW1 = Math.max(w, sizes[index][0]);
        int newH1 = Math.max(h, sizes[index][1]);
        int mul1 = newW1 * newH1;
        int newW2 = Math.max(w, sizes[index][1]);
        int newH2 = Math.max(h, sizes[index][0]);
        int mul2 = newW2 * newH2;

        if(mul1 < mul2) {
            result = Math.min(result, dfs(sizes, index + 1, newW1, newH1));
        } else {
            result = Math.min(result, dfs(sizes, index + 1, newW2, newH2));
        }

        return result;
    }

    public static int solve2(int[][] sizes) {
        return Arrays.stream(sizes).reduce((a, b) -> new int[]{
                Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        }).map(it -> it[0] * it[1]).orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }
}
