//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Количество персон: " + Person.getCounter());
        Person bob = new Person();
        Person alice = new Person();
        Person john = new Person();
        System.out.println("Количество персон: " + Person.getCounter());
    }
}