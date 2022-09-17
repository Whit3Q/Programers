package PROTEST02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public static String[] solution(int n, String[] queries) {
        ArrayList<String> result = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.check && !o2.check) {
                    return 1;
                } else if (!o1.check && o2.check) {
                    return 0;
                }
                return o1.num - o2.num;
            }
        });
        HashMap<String, Point> hm = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            pq.add(new Point(i));
        }

        for (String str : queries) {
            String[] command = str.split(" ");
            if (command[1].equals("request")) { // 할당
                if (hm.containsKey(command[0])) { // 요정한적 있을때
                    if (pq.contains(hm.get(command[0]))) { //할당이 안되어있다면
                        pq.remove(hm.get(command[0]));
                        result.add(command[0] + " 192.168.0." + hm.get(command[0]).num);
                        continue;
                    }
                }
                if (pq.size() == 0) { // 할당할게 없음
                    result.add(command[0] + "  reject");
                } else { //할당 가능
                    hm.put(command[0], pq.poll());
                    result.add(command[0] + " 192.168.0." + hm.get(command[0]).num);
                }
            } else { //할당 해제
                if (hm.containsKey(command[0])) { //할당 받았을 경우
                    hm.get(command[0]).check = true;
                    if (!pq.contains(hm.get(command[0]))) {
                        pq.add(hm.get(command[0]));
                    }
                }
            }
        }

        return result.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] result = solution(2,  new String[] {"desktop1 request", "desktop2 request", "desktop3 request", "desktop3 request", "desktop1 release", "desktop3 request"});

        for(String i : result) {
            System.out.println(i);
        }
    }

    static class Point {
        int num;
        boolean check;

        public Point(int num) {
            this.num = num;
            check = false;
        }

        public Point(int num, boolean check) {
            this.num = num;
            this.check = check;
        }
    }
}
