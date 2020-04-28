package alltasks;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Задача на двумерные массивы
 */
public class ArrayOfArrays {

    public static void main(String[] args) {
        char[][] c = createTable(20, '.');
        printTable(c);

        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);

        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);
    }
    // 1. `createTable(20, '.')` возвращает массив char 20 на 20, все символы в массиве должны быть '.'

    // 2. `printTable` печатает массив на экран. При этом выводите символы подряд, без запятых.
    //   Можете вывести пробелы между символами, так получается более красиво.

    // 3. `fillFirstAndLastLines` Воспользуйтесь `Arrays.fill()`, чтобы заполнить
    //   первую и последнюю строки массива символами '#'.

    // 4. `fillFirstAndLastColumns` Заполните первый и последний столбец массива символами '#'.



    public static char[][] createTable(int size, char initChar) {
        char[][] table = new char[size][];
        for (int i = 0; i < size; i++) {
            table[i] = new char[size];
            Arrays.fill(table[i], initChar);
        }
        return table;
    }

    public static void printTable(char[][] table) {
//        Stream.of(table).forEach(System.out::println); // не знаю, почему это работает
        for (char[] lines : table) {
            for (char chars : lines) {
                System.out.print(chars + " ");
            }
            System.out.println();
        }
    }

    public static void fillFirstAndLastLines(char[][] table, char replaceTo) {
        Arrays.fill(table[0], replaceTo);
        Arrays.fill(table[table.length - 1], replaceTo);
    }

    public static void fillFirstAndLastColumns(char[][] table, char replaceTo) {
        for (int i = 0; i < table.length; i++) {
            table[i][0] = replaceTo;
            table[i][table[i].length - 1] = replaceTo;
        }
    }
}
