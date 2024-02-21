package multithreading;


import java.util.concurrent.Semaphore;

public class Foo {
    private final Semaphore second = new Semaphore(0);
    private final Semaphore third = new Semaphore(0);

    public void first() throws InterruptedException {
        System.out.print("first");
        second.release();
    }

    public void second() throws InterruptedException {
        second.acquire();
        System.out.print("second");
        third.release();
    }

    public void third() throws InterruptedException {
        third.acquire();
        System.out.print("third");
    }
}
