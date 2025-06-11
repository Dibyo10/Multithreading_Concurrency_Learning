package ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor= Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(new ProbeTask(),1000,2000, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new AnotherOne(),1000,2000, TimeUnit.MILLISECONDS);

        try{
            if(!executor.awaitTermination(10000,TimeUnit.MILLISECONDS)){
                executor.shutdownNow();
            }
        }catch(InterruptedException e){
            executor.shutdownNow();

        }
    }
}

class ProbeTask implements Runnable{
    @Override
    public void run(){
        System.out.println("probing1.. with "+Thread.currentThread().getName());
    }
}

class AnotherOne implements Runnable{
    @Override
    public void run(){
        System.out.println("probing2.. with "+Thread.currentThread().getName());
    }
}
