public class Person {
    private static int counter = 0;

    public Person(){
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
