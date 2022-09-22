package PRO43164;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        HashMap<String, ArrayList<Node>> link = new HashMap<>();

        for(int i = 0 ; i < tickets.length; i++) {
            if(link.containsKey(tickets[i][0])) {
                link.get(tickets[i][0]).add(new Node(tickets[i][0], tickets[i][1]));
            } else {
                ArrayList<Node> tmp = new ArrayList<>();
                tmp.add(new Node(tickets[i][0],tickets[i][1]));
                link.put(tickets[i][0], tmp);
            }
        }
        ArrayList<String[]> result = new ArrayList<>();
        Deque<String> visitList = new LinkedList<>();
        visitList.add("ICN");
        dfs(result, link, "ICN", visitList, 0, tickets.length);

        result.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                for (int i = 0; i < o1.length; i++) {
                    int tmp = o1[i].compareTo(o2[i]);
                    if (tmp == 0) {
                        continue;
                    } else {
                        return tmp;
                    }
                }
                return 0;
            }
        });
        for(String[] strs : result) {
            for(String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

        return result.get(0);
    }

    public static void dfs(ArrayList<String[]> result, HashMap<String, ArrayList<Node>> link, String airport, Deque<String> visitList, int count, int targetCount) {
        if(count == targetCount) {
            result.add(visitList.toArray(String[]::new));
            return;
        }

        if (!link.containsKey(airport)) {
            return;
        }

        for(Node now : link.get(airport)) {
            if(now.useCheck) {
                continue;
            }
            now.useCheck = true;
            visitList.add(now.target);
            dfs(result, link, now.target, visitList, count+1,targetCount);
            visitList.pollLast();
            now.useCheck = false;
        }
    }

    static class Node {
        String node;
        String target;
        boolean useCheck;

        public Node(String node, String target) {
            this.node = node;
            this.target = target;
        }

    }

    public static void main(String[] args) {
//        solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
//        solution(new String[][] {{"ICN", "JFK"}, {"JFK", "HND"}, {"HND", "ICN"}, {"ICN", "HND"}});
//        solution(new String[][] {{"ICN", "JFK"}, {"JFK", "HND"}, {"HND", "ICN"}, {"ICN", "JFK"}, {"JFK", "HND"}, {"HND", "ICN"}});
//        solution(new String[][] {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}});
//        solution(new String[][] {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}});
//        solution(new String[][] {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}});
        solution(new String[][] {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}});
//        solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
    }
}
