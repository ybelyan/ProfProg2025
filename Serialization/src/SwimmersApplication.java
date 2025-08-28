public class SwimmersApplication {
    public static final String FILENAME = "net.txt";

    public static void main(String[] args) {
        Sea sea = new Sea();
        sea.giveFish();

        Fisherman fisherman = new Fisherman();
        fisherman.catchFish();
    }
}