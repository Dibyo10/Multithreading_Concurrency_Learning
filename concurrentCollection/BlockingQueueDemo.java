package concurrentCollection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueDemo {
    static final int capacity = 5;
    static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(capacity);

    public static void main(String[] args) {

        try(ExecutorService ex= Executors.newFixedThreadPool(5)){
            Producer producer=new Producer(queue);
            Consumer consumer=new Consumer(queue);
            ex.execute(producer);
            ex.execute(producer);
            ex.execute(producer);
            ex.execute(consumer);
            ex.execute(consumer);
            ex.execute(consumer);

        }


    }
}

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    // Shared static counter for all producers
    private static final AtomicInteger counter = new AtomicInteger();

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int product = counter.getAndIncrement(); // Get a unique number
                queue.put(product);
                System.out.println("Produced: " + product + " by " + Thread.currentThread().getName() + " Queue Size: " + queue.size());

                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // good practice
                 // optionally exit the loop
            }
        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run(){

        while (true){
            try{
                queue.take();
                System.out.println("Consumed: " + "by " + Thread.currentThread().getName()+" Queue Size: " + queue.size());


            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
