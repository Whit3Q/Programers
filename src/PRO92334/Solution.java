package PRO92334;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, ID> hs = new HashMap<>();
        for(int i = 0 ; i < id_list.length; i++) {
            hs.put(id_list[i], new ID(id_list[i]));
        }

        for(String str : Arrays.stream(report).distinct().toArray(String[]::new)) {
            String[] strs = str.split(" ");
            hs.get(strs[0]).declaration.add(strs[1]);
            hs.get(strs[1]).warning++;
        }

        for(int i  = 0; i < id_list.length; i++) {
            for(String name : hs.get(id_list[i]).declaration) {
                if(hs.get(name).warning >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    class ID {
        String name;
        ArrayList<String> declaration;
        int warning;

        public ID(String name) {
            this.name = name;
            declaration = new ArrayList<>();
            warning = 0;
        }
    }
}