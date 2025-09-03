package profprog.ngtu.ru.coffee_shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Barista {

    private static final List<Integer> AVAILABLE_VOLUMES = Arrays.asList(200, 300, 450);

    public Coffee doCoffee(String type, Integer volume) throws IllegalRequestParameter {
        try {
            if (!AVAILABLE_VOLUMES.contains(volume)) {
                throw new IllegalRequestParameter("Неверный объм кофе, мы можем предложить вам один из следующих обЪемов: " +
                        AVAILABLE_VOLUMES.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(", ")));
            }
            CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());
            return new Coffee(coffeeType, volume);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный тип кофе");
            throw new IllegalRequestParameter("Неверный тип кофе, " +
                    "мы можем предложить вам один из следующих напитков: " + CoffeeType.valuesToJoinedString());
        }
    }
}
