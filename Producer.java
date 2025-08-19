package messanger;

public class Producer implements Runnable {

    private MessageQueue queue;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String text = "Hello" + i;
            queue.add(new Message(text));
            System.out.println("Сообщение отправлено: " + text);
        }

    }
}
