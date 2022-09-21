package PRO42839;

import java.util.HashSet;

class Solution {
    static boolean[] prime;
    public static int solution(String numbers) {
        HashSet<Integer> prime = prime();

        int[] arr = new int[numbers.length()];

        for(int i = 0; i < numbers.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }

        boolean[] memory = new boolean[numbers.length()];

        HashSet<Integer> result = new HashSet<>();
        recursive(prime, memory, arr, 0, result);

        return result.size();
    }

    public static void recursive(HashSet<Integer> prime, boolean[] memory, int[] arr, int result, HashSet<Integer> resultHs) {
        if(prime2(result)) {
            resultHs.add(result);
        }
//        if(prime.contains(result)) {
//            resultHs.add(result);
//        }

        for(int i = 0; i < arr.length; i++) {
            if(memory[i]) {
                continue;
            }
            memory[i] = true;
            recursive(prime, memory, arr, (result*10)+arr[i], resultHs);
            memory[i] = false;
        }
    }

    public static HashSet<Integer> prime() {
        prime = new boolean[10000001];
        prime[0] = true;
        prime[1] = true;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 2; i < 10000000; i++) {
            if(prime[i]) {
                continue;
            } else {
                hs.add(i);
                for(int j = 1; j < 10000000; j++) {
                    if(i*j > 10000000) {
                        break;
                    }
                    prime[i*j] = true;
                }
            }
        }
        return hs;
    }

    public static boolean prime2(int n) {
        if(n == 1 || n ==0) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
    }
}