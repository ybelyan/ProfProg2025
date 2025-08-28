public class SwimmerFactory {
    public static Swimmer getSwimmer() {
        return new Swimmer(SwimmerType.FISH, 200);
    }
}
