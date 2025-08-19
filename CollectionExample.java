import messanger.Message;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        /*addListElement(new ArrayList<>(100000));
        addListElement(new LinkedList<>());*/
        Set<Message> messages = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            messages.add(new Message("text"));
        }
        System.out.println("Messages added");
    }

    private static void addListElement(List<Object> list) {
        Date start = new Date();
        for (int i = 0; i < 100000; i++) {
            list.add(0, new Object());
        }
        Date end = new Date();
        System.out.println("Время добавления (мсек): " + (end.getTime() - start.getTime()));
    }
}
