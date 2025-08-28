import java.util.Random;

public class SwimmerFactory {
    public static final Random RANDOM = new Random();
    public static final int MIN_WEIGHT = 100;
    public static final int MAX_WEIGHT = 1000;
    public static Swimmer getSwimmer() {
        return new Swimmer(SwimmerType.random(RANDOM), RANDOM.nextInt(MIN_WEIGHT, MAX_WEIGHT));
    }
}
