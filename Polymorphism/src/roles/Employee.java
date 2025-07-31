package roles;

public class Employee extends Human {
    public Employee() {}

    public Employee(String name){
        super(name);
    }
    @Override
    public void doing() {
        System.out.printf("%s: Привет, я %s работаю.%n", getClass(), name);
    }
}
