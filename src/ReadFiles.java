import java.io.*;

public class ReadFiles {
    public StringBuilder builder;
    public ReadFiles(StringBuilder builder) {
        this.builder = builder;
    }

    public StringBuilder readFile() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/maks/file.txt"));
            for (; ; ) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line + " \n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder;
    }
}