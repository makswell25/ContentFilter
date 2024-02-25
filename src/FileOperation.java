import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Integer> integers = new ArrayList<>();
    ArrayList<Double> floats = new ArrayList<>();
    String errorFileMessage = "Ошибка создания файла!";
    String shortStatisticMessage = "Количество записанных элементов в файлы: ";
    int midInt;
    double midDouble;
    boolean append = false;

    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(String.valueOf(Paths.get("/home/maks/file.txt")))));
            for (; ; ) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                Scanner scanner = new Scanner(line);
                scanner.useLocale(new Locale("en", "en"));
                scanner.useDelimiter("\n");
                if (scanner.hasNextInt()) {
                    integers.add(Integer.valueOf(line));
                } else if (scanner.hasNextDouble()) {
                    floats.add(Double.valueOf(line));
                } else if (scanner.hasNextLine()) {
                    strings.add(line);
                    scanner.close();
                    checkEmptiesLists();
                }
            }
        } catch (
                IOException e) {
            System.err.println("Файл не найден!");
        }
    }

    public void checkEmptiesLists() {
        if (!strings.isEmpty()) {
            writeStringFile();
            stringLengthMax();
            stringLengthMin();
        }
        if (!integers.isEmpty()) {
            writeIntegerFile();
            findsumInt();
            findMiddle();
        }
        if (!floats.isEmpty()) {
            writeFloatFile();
            findsumFloat();
            findMiddle();
        }
    }

    public void writeStringFile() {

        try {
            FileWriter writer = new FileWriter("data/strings.txt", append);
            for (String s : strings) {
                writer.write(s);
                writer.write("\n");
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.err.println(errorFileMessage);
        }
    }


    public void writeIntegerFile() {
        try {
            FileWriter writer = new FileWriter("data/integers.txt", append);
            for (Integer i : integers) {
                writer.write(String.valueOf(i));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println(errorFileMessage);
        }
    }

    public void writeFloatFile() {
        try {
            FileWriter writer = new FileWriter("data/floats.txt", append);
            for (Double d : floats) {
                writer.write(String.valueOf(d));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println(errorFileMessage);
        }
    }

    public int findsumInt() {
        int sumInt = 0;
        for (Integer i : integers) {
            sumInt += i;
        }
        return sumInt;
    }

    public float findsumFloat() {
        float sumFloat = 0;
        for (Double d : floats) {
            sumFloat += d;
        }
        return sumFloat;
    }

    public int stringLengthMax() {
        int maxLength = 0;
        for (String s : strings) {
            int length = s.length();
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    public int stringLengthMin() {
        int minLength = strings.size();
        for (String s : strings) {
            int length = s.length();
            if (length < minLength) {
                minLength = length;
            }
        }
        return minLength;
    }

    public void findMiddle() {
        midInt = findsumInt() / integers.size();
        midDouble = findsumFloat() / floats.size();
    }

    public void viewShortStatistic() {
        System.out.println(shortStatisticMessage
                + "\n" + "strings.txt :" + strings.size()
                + "\n" + "integers.txt :" + integers.size()
                + "\n" + "floats.txt :" + floats.size());
    }

    public void viewStringStatistic() {
        System.out.println("Статистика по строкам: " + "\n" +
                "Количество строк в файле: " + strings.size() + "\n" +
                "Размер которкой строки: " + stringLengthMin() + " символов" + "\n" +
                "Размер длинной строки: " + stringLengthMax() + " символов");
    }

    public void viewFloatStatistic() {
        System.out.println("Статистика по вещественным числам: " + "\n" +
                "Минимальное значение: " + Collections.min(floats) + "\n" +
                "Максимальное значение: " + Collections.max(floats) + "\n" +
                "Сумма чисел: " + findsumFloat() + "\n" +
                "Среднее значение: " + midDouble);
    }

    public void viewIntStatistic() {
        System.out.println("Статистика по числам: " + "\n" +
                "Минимальное значение: " + Collections.min(integers) + "\n" +
                "Максимальное значение: " + Collections.max(integers) + "\n" +
                "Сумма чисел: " + findsumInt() + "\n" +
                "Среднее значение: " + midInt);
    }
}