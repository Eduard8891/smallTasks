package multithreading;


import java.util.concurrent.Semaphore;

public class Foo implements Runnable {
    private int count = 0;
    private final Semaphore semaphore = new Semaphore(1);

    public void first() throws InterruptedException {
        if (count == 0) {
            semaphore.acquire();
            try {
                System.out.println("first");
                count++;
            } finally {
                semaphore.release();
            }
        }
    }

    public void second() throws InterruptedException {
        if (count == 1) {
            semaphore.acquire();
            try {
                System.out.println("second");
                count++;
            } finally {
                semaphore.release();
            }
        } else second();
    }

    public void third() throws InterruptedException {
        if (count == 2) {
            semaphore.acquire();
            try {
                System.out.println("third");
                count = 0;
            } finally {
                semaphore.release();
            }
        } else third();
    }

    @Override
    public void run() {
    }
}
