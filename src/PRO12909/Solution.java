package PRO12909;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();


        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' :
                    stack.add('(');
                    break;
                case ')' :
                    if(stack.isEmpty()) {
                        return false;
                    }
                    char now = stack.pop();
                    if(now != '(') {
                        return false;
                    }
                    break;
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}