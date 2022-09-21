package PRO43163;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] memory = new boolean[words.length];
        int answer = dfs(begin, target, words, memory, 0);
        if(answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }

    public int dfs(String begin, String target, String[] words, boolean[] memory, int count) {
        if (begin.equals(target)) {
            return count;
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < memory.length; i++) {
            if(memory[i] || !check(begin, words[i])) {
                continue;
            }
            memory[i] = true;
            result = Math.min(result, dfs(words[i], target, words, memory, count+1));
            memory[i] = false;
        }

        return result;
    }

    public boolean check(String begin, String word) {
        int count = 0;
        for(int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
