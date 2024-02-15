import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        ReadFiles files = new ReadFiles();
        files.readFile();
        System.out.println(files.toString());

    }
}