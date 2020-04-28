package alltasks;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Задачи на массивы
 */
public class ArraysTasks {

    public static void main(String[] args) {
        // task 1
        System.out.println(Arrays.toString(task1(8))); // [2, 4, 6, 8, 10, 12, 14, 16]

        // task 2
        System.out.println(hasSimilar(new int[] { 12, 13, 12, 4})); // true
        System.out.println(hasSimilar(new int[] { 12, 13, 16, 4})); // false

        // task 3
        System.out.println(task3(new int[] {1, 2, 4, 6})); // 6.5

        // task 4
        System.out.println(Arrays.toString(sortReverse(new int[] { 12, 13, 16, 4}))); // [4, 16, 13, 12]
    }



    public static int[] task1(int n) {
        return IntStream.iterate(2, i -> i + 2).limit(n).toArray();
    }

    public static boolean hasSimilar(int[] a) {
        return !Arrays.equals(Arrays.stream(a).distinct().toArray(), a);
    }

    public static double task3(int[] array) {
        return Arrays.stream(array).sum() / (double) array.length;
    }

    public static int[] sortReverse(int[] a) {
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        int[] tmp = b.clone();
        for (int i = 0; i < b.length; i++) {
            b[i] = tmp[b.length - 1 - i];
        }
        return b;
    }
}
