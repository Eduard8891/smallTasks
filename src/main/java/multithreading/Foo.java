package multithreading;


public class Foo implements Runnable {

    public void first() throws InterruptedException {
        syncMethod("first");
    }

    public void second() throws InterruptedException {
        syncMethod("second");
    }

    public void third() throws InterruptedException {
        syncMethod("third");
    }

    public synchronized void syncMethod(String thread) throws InterruptedException {
        if (thread.equals("first")) {
            System.out.println(thread);
            notifyAll();
        } else
            switch (thread) {
                case "second": {
                    wait();
                    System.out.println(thread);
                    notifyAll();
                }
                case "third": {
                    wait();
                    System.out.println(thread);
                }
            }
    }

    @Override
    public void run() {
    }
}
