import java.io.*;

public class FileHandler {
    public String read(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Файл не найден %s: %s%s", filename, e.getMessage(), System.lineSeparator());
        } catch (IOException e) {
            System.out.printf("Ошибка при чтении файла %s: %s\n", filename, e.getMessage());
        }
        return stringBuilder.toString();
    }

    public void write(String filename, String text) {
        try(FileWriter writer = new FileWriter(filename)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.printf("Ошибка при записи в файл %s: %s\n", filename, e.getMessage());
        }
    }
}
