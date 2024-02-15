import java.io.*;
import java.nio.file.Path;

public class ReadFiles {
    StringBuilder builder = new StringBuilder();
    public void readFile() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/maks/file.txt"));
            for (; ; ) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line + " \n");
            }
        } catch (
                FileNotFoundException ex) {
            System.err.println("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return builder.toString();
    }
}
