package PRO12906;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        if(arr.length > 0) {
            int tmp = arr[0];
            result.add(tmp);
            for(int now : arr) {
                if(tmp == now) {
                    continue;
                } else {
                    result.add(now);
                    tmp = now;
                }
            }
        }


        return result.stream().mapToInt(i -> i).toArray();
    }
}