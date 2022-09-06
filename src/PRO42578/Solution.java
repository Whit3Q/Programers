package PRO42578;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for (int y = 0; y < clothes.length; y++) {
            hm.put(clothes[y][1], hm.getOrDefault(clothes[y][1], 0)+1);
        }

        int[] list = new int[hm.size()];
        Iterator<Map.Entry<String, Integer>> it = hm.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}, {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}