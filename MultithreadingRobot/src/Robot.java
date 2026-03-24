public class Robot {
    private final static int NUMBER_OF_STEPS = 5;
    private static boolean isLeftGo = true;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread leftFoot = new Thread(() -> {
            for (int i = 0; i < NUMBER_OF_STEPS; i++) {
                synchronized (lock) {
                    while (!isLeftGo) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println(Thread.currentThread().getName() + ": interrupted");
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": step");
                    isLeftGo = !isLeftGo;
                    lock.notify();
                }
            }
        }, "LEFT");
        Thread rightFoot = new Thread(() -> {
            for (int i = 0; i < NUMBER_OF_STEPS; i++) {
                synchronized (lock) {
                    while (isLeftGo) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println(Thread.currentThread().getName() + ": interrupted");
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": step");
                    isLeftGo = !isLeftGo;
                    lock.notify();
                }
            }
        }, "RIGHT");

        leftFoot.start();
        rightFoot.start();
    }
}