package alltasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задачи на регулярные выражения
 */
public class Regexes {

    public static void main(String[] args) {
        System.out.println(isEmail("k_konnov@protonmail.com")); // true
        System.out.println(killWrongSpaces("Это строка , у которой зачем-то написаны два пробела перед запятой"));
        System.out.println(wordReplacer("Какая-то сине-зеленовая трава")); // то-Какая зеленовая-сине трава
        System.out.println(howManyCats("кот кОтяра КОТЕЧКА")); // 3
        // replacerInFiles("in.txt", "out.txt");
    }



    public static boolean isEmail(String s) {
        return s.matches("[a-z_.-]+@[a-z_.-]+\\.([a-z]{2,4}|)");
    }

    public static String killWrongSpaces(String s) {
        return s.replaceAll("\\s+,", ",");
    }

    public static String wordReplacer(String s) {
        return s.replaceAll("([а-яА-Я]+)-([а-яА-Я]+)", "$2-$1");
    }

    public static int howManyCats(String s) {
        Pattern p = Pattern.compile("кот", Pattern.UNICODE_CASE + Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        int counter = 0;
        while (m.find()) counter++;
        return counter;
    }

    public static void replacerInFiles(String inPath, String outPath)  {
        try {
            String s = Files.readString(Path.of(inPath));

            Pattern p = Pattern.compile("(\\d+)");
            Matcher m = p.matcher(s);
            StringBuilder result = new StringBuilder();
            while (m.find()) {
                int val = Integer.parseInt(m.group(0));
                m.appendReplacement(result, "" + (val + 1));
            }
            m.appendTail(result);

            Files.writeString(Path.of(outPath), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
