package PRO12906;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();
        int tmp = 10;

        for (int now : arr) {
            if (tmp != now) {
                result.add(now);
                tmp = now;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}