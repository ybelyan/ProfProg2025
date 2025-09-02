import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Sea implements Runnable {
    @Override
    public void run() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SwimmersApplication.FILENAME))) {
            List<Swimmer> swimmers = new ArrayList<>();
            for (int i = 0; i < SwimmersApplication.NET_SIZE; i++) {
                swimmers.add(SwimmerFactory.getSwimmer());
            }
            oos.writeObject(swimmers);
            System.out.println("Новая партия морских обитателей");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + SwimmersApplication.FILENAME + ": " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл " + SwimmersApplication.FILENAME + ": " + e.getMessage());
        }
    }
}
