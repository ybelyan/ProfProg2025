import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Fisherman implements Runnable {
    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SwimmersApplication.FILENAME))) {
            List<Swimmer> swimmers = (List<Swimmer>)ois.readObject();
            List<Can<Swimmer>> cans = prepareFish(swimmers);
            System.out.println(Thread.currentThread() + " Рыбные консервы: " + cans.size());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + SwimmersApplication.FILENAME + ": " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла " + SwimmersApplication.FILENAME + ": " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Класс Swimmer не найден: " + e.getMessage());
        }
    }

    private List<Can<Swimmer>> prepareFish(List<Swimmer> swimmers) {
        return swimmers.stream()
                .peek(System.out::println)
                .filter(s -> SwimmerType.FISH.equals(s.getType()))
                .filter(s -> s.getWeight() > 500)
                .map(Swimmer::cookCannedSwimmer)
                .toList();
    }
}
