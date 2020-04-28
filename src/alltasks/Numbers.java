package alltasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Задачи на теорию чисел.
 */
public class Numbers {

    public static void main(String[] args) {
        // task 1
        for (int i = 1; i <= 42; i++) {
            if (isPrimary(i)) System.out.println("# " + i);
        }

        // task 2
        System.out.println(Arrays.toString(sieveOfEratosthenes(42)));
        // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41]
    }



    public static boolean isPrimary(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean[] sieveOfEratosthenesBool(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false; // Предполагаю, что 1 - не простое

        for (int i = 2; i*i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n + 1; j+= i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    public static Integer[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = sieveOfEratosthenesBool(n);

        List<Integer> primes = new ArrayList<>();

        for (int i = 1; i < isPrime.length; i++) {
            if (isPrime[i]) { primes.add(i); }
        }
        return primes.toArray(Integer[]::new);
    }
}
