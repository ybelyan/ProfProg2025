import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SwimmersApplication {
    public static final String FILENAME = "net.txt";
    public static final int NET_SIZE = 10;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        try(ScheduledExecutorService service = Executors.newScheduledThreadPool(3)) {
            service.scheduleAtFixedRate(new Sea(), 0, 5, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(new Fisherman(), 4, 10, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(new Fisherman(), 9, 10, TimeUnit.SECONDS);
            while(!"q".equals(SCANNER.next())){

            }
            service.shutdown();
        }

        /*List<Swimmer> swimmers = new ArrayList<>();
        for (int i = 0; i < NET_SIZE; i++) {
            swimmers.add(SwimmerFactory.getSwimmer());
        }

        List<Swimmer> fishes = new ArrayList<>();
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
        }

        System.out.println("Рыбные консервы: " + cans.size());*/

    }


}