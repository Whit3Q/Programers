package PRO42576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PRO42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < participant.length; i++) {
            hm.put(participant[i], hm.getOrDefault(participant[i], 0)+1);
        }

        for(int i = 0; i < completion.length; i++) {
            hm.put(completion[i], hm.get(completion[i]) - 1);
        }

        for(String name : hm.keySet()) {
            if(hm.get(name) != 0) {
                return name;
            }
        }

        /*
        //Entry 로 풀어도 된다 문제에서는 속도가 케이스마다 빠른게 있고 느린게 있다.
        // 참고 https://stackoverflow.com/questions/3870064/performance-considerations-for-keyset-and-entryset-of-map
            Map<String, Integer> hm = new HashMap<>();
            for(Map.Entry<String, Integer> entry : hm.entrySet()) {
                if(entry.getValue() != 0) {
                return entry.getKey();
            }
        }
         */


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


    }
}
