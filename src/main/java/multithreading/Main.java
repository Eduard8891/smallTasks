package multithreading;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        CompletableFuture.runAsync(() -> {
            try {
                foo.second();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        CompletableFuture.runAsync(() -> {
            try {
                foo.third();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        CompletableFuture.runAsync(() -> {
            try {
                foo.first();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        Thread.sleep(1000);
    }
}


