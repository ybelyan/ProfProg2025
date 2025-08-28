import java.io.Serializable;

public class Swimmer implements Serializable {
    private final SwimmerType type;
    private final transient int weight;

    public Swimmer(SwimmerType type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public SwimmerType getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Swimmer{" +
                "type=" + type +
                ", weight=" + weight +
                '}';
    }
}
