package messanger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MessageQueue {
    BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);

    public void add(Message message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            System.out.println("Очередь переполнена");
        }
    }

    public Message poll() {
        try {
            return queue.poll(100, TimeUnit.MILLISECONDS);
        } catch(InterruptedException e) {
            System.out.println("Очередь пуста");
            return null;
        }
    }
}
