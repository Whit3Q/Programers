package PROTEST02;

import java.util.ArrayList;
import java.util.HashMap;

class Solution2 {
    public static String[] solution(int n, String[] queries) {
        String[] answer = {};

        ArrayList<String> result = new ArrayList<>();
        boolean[] firstCheck = new boolean[n+1]; //한번이라도 방문 했는가?
        firstCheck[0] = true;
        boolean[] nowCheck = new boolean[n+1]; //현재 분출 상태
        nowCheck[0] = true;

        HashMap<String, Integer> hm = new HashMap<>(); //사용자 현황

        for(String str : queries) {
            String[] commandStr = str.split(" ");
            if(commandStr[1].equals("request")) { // 할당 요청

                if(hm.containsKey(commandStr[0])) { //할당 받은 적 있을 때
                    int tmpIndex = hm.get(commandStr[0]);
                    int tmpResult = assign(firstCheck, nowCheck);
                    if(tmpResult != -1) {
                        hm.put(commandStr[0], tmpResult);
                        result.add(commandStr[0]+" 192.168.0."+tmpResult);
                    } else {
                        result.add(commandStr[0]+" reject");
                    }
                } else { //할당 받은 적 없을 때
                    int tmpResult = assign(firstCheck, nowCheck);
                    if(tmpResult != -1) {
                        hm.put(commandStr[0], tmpResult);
                        result.add(commandStr[0]+" 192.168.0."+tmpResult);
                    } else {
                        result.add(commandStr[0]+" reject");
                    }
                }

            } else { // 할당 해제
                if(hm.containsKey(commandStr[0])) {
                    nowCheck[hm.get(commandStr[0])] = false;
                }
            }

        }


        return result.stream().toArray(String[]::new);
    }

    public static int assign(boolean[] firstCheck, boolean[] nowCheck) {
        boolean checkOne = false;
        for(int i = 0; i < firstCheck.length; i++) {
            if(!firstCheck[i]) {
                nowCheck[i] = true;
                firstCheck[i] = true;
                return i;
            }
        }
        if(!checkOne) {
            for(int i = 0; i < nowCheck.length; i++) {
                if(!nowCheck[i]) {
                    nowCheck[i] = true;
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] result = solution(2,  new String[] {"desktop1 request", "desktop2 request", "desktop3 request", "desktop3 request", "desktop1 release", "desktop3 request"});

        for(String i : result) {
            System.out.println(i);
        }
    }
}