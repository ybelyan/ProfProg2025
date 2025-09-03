package profprog.ngtu.ru.coffee_shop;

public class Coffee {
    private CoffeeType type;
    private Integer volume;

    public Coffee(CoffeeType type, Integer volume) {
        this.type = type;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return type + " " + volume + " мл";
    }
}
