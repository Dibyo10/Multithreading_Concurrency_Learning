package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo{
    public static void main(String[] args) {
        try(ExecutorService executor= Executors.newFixedThreadPool(10)){
            for (int i = 0; i <20 ; i++) {
                executor.execute(new Worker(i));


            }

        }

    }

}

class Worker implements Runnable{
    int taskid;

    public Worker(int taskid){
        this.taskid=taskid;
    }

    @Override
    public void run(){
        System.out.println("TaskID: "+taskid+" executed by thread "+Thread.currentThread().getName());

        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}