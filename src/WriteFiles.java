import java.nio.file.Files;
import java.util.ArrayList;

public class WriteFiles {
    public void writeToString() {

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add(Integer.toString(i));
        }
        //Files.write();
        System.out.println("");
    }
}
