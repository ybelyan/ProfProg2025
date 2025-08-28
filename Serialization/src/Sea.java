import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Sea {
    public void giveFish() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SwimmersApplication.FILENAME))) {
            Swimmer swimmer = SwimmerFactory.getSwimmer();
            oos.writeObject(swimmer);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + SwimmersApplication.FILENAME + ": " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл " + SwimmersApplication.FILENAME + ": " + e.getMessage());
        }
    }
}
