import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Fisherman {
    public void catchFish() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SwimmersApplication.FILENAME))) {
            Swimmer swimmer = (Swimmer)ois.readObject();
            System.out.println(swimmer);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + SwimmersApplication.FILENAME + ": " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла " + SwimmersApplication.FILENAME + ": " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Класс Swimmer не найден: " + e.getMessage());
        }
    }
}
