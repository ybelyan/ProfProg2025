package roles;

public abstract class Human {
    protected final String name;

    protected Human(String name){
        this.name = name;
    }

    protected Human() {
        this("Noname");
    }

    public final String getName() {
        return name;
    }

    public abstract void doing();
}
