package PRO42579;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> hm = new HashMap<>(); //장르 넘버 매칭 및 중복 제거
        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>(); // 배열 0번에는 총합 다음부턴 크기2짜리 배열 0번에는 재생수 1번에는 곡 인덱스 ex) [500,0] [600, 1] [150, 2] [800, 3] [2500, 4]

        int index = 0; //장르 넘버
        for(int i = 0; i < genres.length; i++) { //입력값 순회
            if(!hm.containsKey(genres[i])) { //추가안된 장르인지 체크
                hm.put(genres[i],index);
                list.add(new ArrayList<>());
                list.get(index).add(new Integer[] {plays[i]+1}); // 총량 구하기 +1은 나중에 정렬때 제외하기 위해 제일 큰값으로 만들어 주기위해 각 장르마다 +1
                list.get(index).add(new Integer[] {plays[i],i});
                index++;
            } else { //이미 추가된 장르
                Integer sum = list.get(hm.get(genres[i])).get(0)[0];
                sum += plays[i];
                list.get(hm.get(genres[i])).set(0, new Integer[] {sum}); //총량 더하기
                list.get(hm.get(genres[i])).add(new Integer[] {plays[i],i});
            }
        }

        Collections.sort(list, new Comparator<ArrayList<Integer[]>>() { //장르별 총합이 큰 수대로 정렬
            @Override
            public int compare(ArrayList<Integer[]> o1, ArrayList<Integer[]> o2) {
                return o2.get(0)[0] - o1.get(0)[0];
            }
        });

        ArrayList<Integer> result = new ArrayList<>(); //결과값 담을 리스트

        for(int i = 0 ; i < list.size(); i++) { // 장르 전체 순회
            ArrayList<Integer[]> tmp = list.get(i);
            Collections.sort(tmp, new Comparator<Integer[]>() { //장르에서 재생수대로 정렬
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    return o2[0] - o1[0];
                }
            });

            if(tmp.size() < 3) { //만약 2개보다 작을 경우 즉 1개인 경우 추가
                result.add(tmp.get(1)[1]);
                continue;
            }
            for(int j = 1; j < 3; j++) { // 각 장르마다 2개씩 담기
                result.add(tmp.get(j)[1]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray(); //결과값 스트림을 이용해서 ArrayList에서 int[] 배열로 변환 후 출력
    }

    public static void main(String[] args) {
        int[] result = solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});

        for(int n : result) {
            System.out.println(n);
        }
    }
}