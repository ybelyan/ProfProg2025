package treads;

public class ChildThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " запущен.");
        int counter = 1;
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Итерация цикла " + counter++);
        }
        System.out.println(Thread.currentThread().getName() + " остановлен.");
    }
}
