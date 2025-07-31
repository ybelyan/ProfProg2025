import work.Manager;
import work.Tester;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Manager manager = new Manager("Ivanov", "Ivan", "manager", 2000, 5);
        System.out.println(manager.getJobTitle());
        manager.manageProject();
        System.out.println("Bonus: " + manager.calculateBonus());

        Tester tester = new Tester("Petrov", "Petr", "tester", 1500);
        System.out.println(tester.getJobTitle());
        tester.testCode();
        System.out.println("Bonus: " + tester.calculateBonus());


    }
}