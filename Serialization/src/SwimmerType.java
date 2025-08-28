import java.util.Arrays;
import java.util.Random;

public enum SwimmerType {
    FISH,
    CRAB,
    SQUID,
    JELLYFISH,
    OCTOPUS;

    public static SwimmerType random(Random random) {
        return Arrays.asList(values()).get(random.nextInt(values().length));
    }
}
