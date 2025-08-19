package messanger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        try( ExecutorService producerExecutor = Executors.newSingleThreadExecutor();
        ExecutorService consumerExecutor = Executors.newSingleThreadExecutor()) {
            producerExecutor.submit(new Producer(queue));
            consumerExecutor.submit(new Consumer(queue));

            consumerExecutor.shutdown();
            producerExecutor.shutdown();
        }

    }
}
