import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        ReadFiles rf = new ReadFiles();
        rf.readFile();
        rf.printSizeArraylists();
    }
}