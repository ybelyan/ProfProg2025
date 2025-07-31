package roles;

public class Friend extends Human {
    public Friend(String name) {
        super(name);
    }
    public void doing() {
        System.out.printf("%s: Привет, я %s общаюсь с другом.%n", this.getClass(), getName());
    }

    /*@Override
    public String getName() {
        return "Друг " + super.getName();
    }*/
}
