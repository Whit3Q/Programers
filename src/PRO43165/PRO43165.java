package PRO43165;

public class PRO43165 {
    public int solution(int[] numbers, int target) {

        return solve(numbers, target, 1, numbers[0]) + solve(numbers, target, 1, -numbers[0]);
    }

    private int solve(int[] numbers, int target, int index, int sum) {
        if (numbers.length == index) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        int result = solve(numbers, target, index + 1, sum + numbers[index])
                + solve(numbers, target, index + 1, sum - numbers[index]);

        return result;
    }
}

