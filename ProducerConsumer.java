import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> queue=new ArrayBlockingQueue<>(5);
        Thread p1=new Thread(new Producer(queue));
        Thread p2=new Thread(new Producer(queue));
        Thread c1=new Thread(new Consumer(queue));
        Thread c2=new Thread(new Consumer(queue));


        p1.start();
        p2.start();
        c1.start();
        c2.start();


    }


}

class Producer implements Runnable{
    private BlockingQueue<String> queue;

    Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true){
            try{
                queue.put("Product");
                System.out.println("Produced by " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }

    }

}

class Consumer implements Runnable{
    private BlockingQueue<String> queue;

    Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        while(true){
            try{
                String product = queue.take();
                System.out.println("Consumed by " + Thread.currentThread().getName());
                Thread.sleep(1200);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }

        }

    }

}