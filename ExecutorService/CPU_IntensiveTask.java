package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPU_IntensiveTask {
    public static void main(String[] args) {
        int cores=Runtime.getRuntime().availableProcessors();
        ExecutorService executor= Executors.newFixedThreadPool(cores);
        System.out.println("Created thread pool with : "+cores+" cores");
        for (int i = 0; i <20 ; i++) {
            executor.execute(new CPUTask());

        }
    }
}

class CPUTask implements Runnable{
    @Override
    public void run(){
        System.out.println("task done by "+Thread.currentThread().getName());
    }
}
