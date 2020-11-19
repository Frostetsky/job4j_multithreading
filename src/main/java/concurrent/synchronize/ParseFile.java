package concurrent.synchronize;

import java.io.*;
import java.util.function.Predicate;

public class ParseFile {
    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent(Predicate<Integer> condition) {
        StringBuilder builder = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            for (int data = -2; data != -1; data = i.read()) {
                if (condition.test(data)) {
                    builder.append(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public synchronized String getContentWithoutUnicode() {
        return getContent(data -> data < 0x80);
    }

    public synchronized String getGeneralContent() {
        return getContent(data -> true);
    }

    public synchronized void saveContent(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}