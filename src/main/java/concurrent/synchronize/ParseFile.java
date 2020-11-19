package concurrent.synchronize;

import java.io.*;

public class ParseFile {
    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() {
        StringBuilder builder = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            for (int data = -2; data != -1; data = i.read()) {
                builder.append(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public synchronized String getContentWithoutUnicode() {
        StringBuilder builder = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            for (int data = -2; data != -1; data = i.read()) {
                if (data < 0x80) {
                    builder.append(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public synchronized void saveContent(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}