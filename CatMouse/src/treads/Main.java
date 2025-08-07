package treads;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " запущен.");
        ChildThread task = new ChildThread();
        Thread childThread = new Thread(task, "Child thread");
        childThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " прерван.");
        }
        childThread.interrupt();
        System.out.println(Thread.currentThread().getName() + " завершается.");
    }
}
