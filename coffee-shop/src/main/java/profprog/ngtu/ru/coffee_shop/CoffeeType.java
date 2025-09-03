package profprog.ngtu.ru.coffee_shop;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CoffeeType {
    CAPPUCCINO,
    LATTE,
    AMERICANO,
    ESPRESSO;

    public static String valuesToJoinedString() {
        return Stream.of(CoffeeType.values())
                .map(CoffeeType::name)
                .collect(Collectors.joining(", "));
    }
}
