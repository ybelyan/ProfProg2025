package profprog.ngtu.ru.coffee_shop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Paymaster {

    private final Barista barista;

    public Paymaster(Barista barista){
        this.barista = barista;
    }

    @GetMapping("/order")
    public ResponseEntity<String> orderCoffee(@RequestParam("name") String name,
                                              @RequestParam("type") String type,
                                              @RequestParam("volume") Integer volume){
        try {
            Coffee coffee = barista.doCoffee(type, volume);
            String response = String.format("%s, %s для вас готов!", name, coffee.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(IllegalRequestParameter e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
