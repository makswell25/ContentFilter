import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        WriteFiles wf = new WriteFiles();
        try {
            wf.sortStringsToType();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}