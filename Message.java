package messanger;

import java.util.Objects;
import java.util.Random;

public class Message {

    private String text;
    private int id;
    private final static Random RANDOM = new Random();

    public Message(String text) {
        this.text = text;
        this.id = RANDOM.nextInt();
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Message message = (Message) obj;
        return id == message.id && Objects.equals(text, message.text);
    }
}
