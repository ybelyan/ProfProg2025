import java.util.ArrayList;
import java.util.List;

public class SwimmersApplication {
    public static final String FILENAME = "net.txt";
    public static final int NET_SIZE = 10;

    public static void main(String[] args) {
        /*Sea sea = new Sea();
        sea.giveFish();

        Fisherman fisherman = new Fisherman();
        fisherman.catchFish();*/

        List<Swimmer> swimmers = new ArrayList<>();
        for (int i = 0; i < NET_SIZE; i++) {
            swimmers.add(SwimmerFactory.getSwimmer());
        }

        List<Can<Swimmer>> cans = swimmers.stream()
                .peek(System.out::println)
                .filter(s -> SwimmerType.FISH.equals(s.getType()))
                .filter(s -> s.getWeight() > 500)
                .map(Swimmer::cookCannedSwimmer)
                .toList();

        /*List<Swimmer> fishes = new ArrayList<>();
        for (Swimmer swimmer : swimmers) {
            System.out.println(swimmer);
            if (SwimmerType.FISH.equals(swimmer.getType())) {
                if (swimmer.getWeight() > 500) {
                    fishes.add(swimmer);
                }
            }
        }

        List<Can<Swimmer>> cans = new ArrayList<>();
        for(Swimmer fish : fishes) {
            Can<Swimmer> can = fish.cookCannedSwimmer();
            cans.add(can);
        }*/

        System.out.println("Рыбные консервы: " + cans.size());


    }
}