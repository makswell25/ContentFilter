import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteFiles {
    StringBuilder sb = new StringBuilder();
    ReadFiles readFiles = new ReadFiles(sb);
    String regexString = "[A-Za-z][А-Яа-я]";
    String regexNum = "[0-9]";
    FileOutputStream fs;

    public void sortStringsToType() throws FileNotFoundException {
        readFiles.readFile();
        String[] strings = sb.toString().split("\n");
        if (strings.) {
            fs = new FileOutputStream("/home/maks/Документы/Java/Shift/ContentFilter/data/strings.txt");
            writeFile();
        }
    }

    public void writeFile() {
        try {
            fs.write(sb.toString().getBytes());
            fs.flush();
            fs.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isString (String str) {
        return str.matches(regexString);
    }
    public boolean isNum(String str) {
        return str.matches(regexNum);
    }
}