package PRO42842;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int size = (brown - 2)/2;
        int x = size;
        for(int y = 1; y <= size; y++,x--) {
            if(y*(x-2) == yellow && y <= x) {
                return new int[] {y, x};
            }
        }

        return answer;
    }
}