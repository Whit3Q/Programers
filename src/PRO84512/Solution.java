package PRO84512;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static int solution(String word) {
        int answer = 0;
        HashSet<String> list = new HashSet<>();
        String[] arr = {"","A","E","I","O","U"};

        dfs(list, arr, "", 0);

        String[] result = list.toArray(String[]::new);
        Arrays.sort(result);
        for(int i = 0; i < result.length; i++) {
            if(word.equals(result[i])) {
                answer = i;
            }
        }

        return answer;
    }

    public static void dfs(HashSet<String> list, String[] arr, String str, int count) {
        if(count == 5) {
            list.add(str);
            return;
        }

        for(int i = 0; i < 6; i++) {
            dfs(list,arr,str+arr[i],count+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }
}