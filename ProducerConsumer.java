import java.util.ArrayList;

public class ProducerConsumer {
    public static void main(String[] args) {
        Worker worker=new Worker(5,0);

        Thread producer=new Thread(()->{
            try {
                worker.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer=new Thread(()->{
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();

    }


}

class Worker{

    private int sequence=1;
    private final Integer top;
    private final Integer bottom;
    private final ArrayList<Integer> container;
    private final Object lock=new Object();

    public Worker(Integer top, Integer bottom){
        this.top=top;
        this.bottom=bottom;
        this.container=new ArrayList<>();
    }


    public void produce() throws InterruptedException{
        synchronized (lock){
            while(true){
                if(container.size()==top){
                    System.out.println("container full, waiting for items to remove..");

                    lock.wait();
                }else{
                    System.out.println(sequence+ " produced and added ");
                    container.add(sequence++);
                    lock.notify();
                }

                Thread.sleep(500);
            }
        }

    }

    public void consume() throws InterruptedException{
        synchronized (lock){
            while(true){
                if(container.size()==bottom){
                    System.out.println("Container empty..");
                    lock.wait();
                }else{
                    System.out.println(container.removeFirst()+" consumed from the container");
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }

    }
}
