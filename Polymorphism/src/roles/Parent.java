package roles;

public class Parent extends Human {
    public Parent() {}

    public Parent(String name){
        super(name);
    }
    @Override
    public void doing() {
        System.out.printf("%s: Привет, я %s забочусь о своем ребенке.%n", getClass(), getName());
    }
}
