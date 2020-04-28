package alltasks;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Задачи на чтение и запись в файлы
 */
public class IOTasks {

    public static void main(String[] args) {
        File in = new File("in.txt");
        File out = new File("out.txt");

        task1(in);
        task2(new String[] {"qwerty", "123456", "hello"}, "out.txt");
        task3(in, out);
        task4(in);
    }



    public static void task1(File input) {
        int sum = 0;
        try (Scanner scan = new Scanner(input)) {
            while (scan.hasNext()) sum += intOrZeroOf(scan.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
    public static int intOrZeroOf(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ignored) {
            return 0;
        }
    }

    public static void task2(String[] lines, String fileName) {
        try (PrintStream ps = new PrintStream(new File(fileName))) {
            for (String line: lines) {
                ps.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void task3(File in, File out) {
        boolean isFirstWordInSentence = true;

        try (Scanner scan = new Scanner(in); PrintStream ps = new PrintStream(out)) {
            while (scan.hasNext()) {
                String word = scan.next();
                StringBuilder sb = new StringBuilder(word.toLowerCase());

                if (isFirstWordInSentence) {
                    sb.setCharAt(0, word.toUpperCase().charAt(0));
                }

                char last = word.charAt(word.length() - 1);
                isFirstWordInSentence = "!.?".contains(String.valueOf(last));

                ps.print(sb.toString() + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void task4(File in) {
        List<String> words = new LinkedList<>();

        try (Scanner scan = new Scanner(in)) {
            while (scan.hasNext()) words.add(scan.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String word : words) {
            System.out.print("\r");
            System.out.print(word);
            System.out.flush();

            if ("!.,?".contains(String.valueOf(word.charAt(word.length() - 1)))) {
                sleep(800); // Thread.sleep() throws InterruptedException
            } else {
                sleep(500);
            }
        }

        System.out.println("\r" + "~This is the end!~");
    }
    public static void sleep(int ms) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= ms);
    }
}
