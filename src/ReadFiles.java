import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFiles {
    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Integer> integers = new ArrayList<>();
    ArrayList<Double> floats = new ArrayList<>();
    String errorFileMessage = "Ошибка создания файла!";
    String shortStatisticMessage = "Количество записанных элементов в файлы: ";

    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(String.valueOf(Paths.get("data/file.txt")))));
            for (; ; ) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                Scanner scanner = new Scanner(line);
                // scanner.useLocale(new Locale("ru", "ru"));
                scanner.useDelimiter("\n");
                if (scanner.hasNextInt()) {
                    integers.add(Integer.valueOf(line));
                } else if (scanner.hasNextLine()) {
                    strings.add(line);
                } else if (scanner.hasNextDouble()) {
                    floats.add(Double.valueOf(line));
                }
                scanner.close();
                writeStringFile();
                writeIntegerFile();
                writeFloatFile();
            }
        } catch (
                IOException e) {
            System.err.println("Файл не найден!");
        }
    }

    public void writeStringFile() {
        if (!strings.isEmpty()) {
            try {
                FileWriter writer = new FileWriter("data/strings.txt");
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
    }


    public void writeIntegerFile() {
        if (!integers.isEmpty()) {
            try {
                FileWriter writer = new FileWriter("data/integers.txt");
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
    }

    public void writeFloatFile() {
        if (!floats.isEmpty()) {
            try {
                PrintWriter writer = new PrintWriter("data/floats.txt");
                for (Double f : floats) {
                    writer.write(String.valueOf(f));
                    writer.write("\n");
                }
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.err.println(errorFileMessage);
            }
        }
    }

    public void printSizeArraylists() {
        System.out.println(shortStatisticMessage
                + "\n" + "strings.txt :" + strings.size()
                + "\n" + "integers.txt :" + integers.size()
                + "\n" + "floats.txt :" + floats.size());
    }

}