import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RobotLock {
    private final static int NUMBER_OF_STEPS = 500;
    private static final Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread leftFoot = new Thread(() -> {
            for (int i = 0; i < NUMBER_OF_STEPS; i++) {
               lock.lock();
               try{
                   System.out.println(Thread.currentThread().getName() + " step" + i);
               }
               finally {
                   lock.unlock();
               }
            }
        }, "LEFT");
        Thread rightFoot = new Thread(() -> {
            for (int i = 0; i < NUMBER_OF_STEPS; i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " step" + i);
                }
                finally {
                    lock.unlock();
                }
            }
        }, "RIGHT");

        leftFoot.start();
        rightFoot.start();
    }
}