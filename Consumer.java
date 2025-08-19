package messanger;

public class Consumer implements Runnable {
    private MessageQueue queue;

    public Consumer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            Message message = queue.poll();
            System.out.println("Получено сообщение: " + message.getText());
        }

    }
}
