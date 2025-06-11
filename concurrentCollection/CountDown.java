package concurrentCollection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDown {
    public static void main(String[] args) throws InterruptedException {

        int chefs=10;

        CountDownLatch latch=new CountDownLatch(chefs);

        try(ExecutorService ex= Executors.newFixedThreadPool(chefs)){
            for (int i = 0; i < 10; i++) {
                ex.execute(new Chef("Dibyo","Pizza",latch));
                Thread.sleep(1000);


            }
        }
        latch.await();

        System.out.println("All dishes ready..");

    }
}

class Chef implements Runnable{
    private final String name;
    private final String dish;
    private final CountDownLatch latch;

    public Chef(String name, String dish, CountDownLatch latch){
        this.dish=dish;
        this.name=name;
        this.latch=latch;

    }
    @Override
    public void run(){

        try{
            System.out.println(name+" is preparing "+dish+" by "+Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(name+" has finished preparing "+dish+" by "+Thread.currentThread().getName());
            latch.countDown();
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}

