package ExecutorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        try(ExecutorService executor=Executors.newCachedThreadPool()){
            for (int i = 0; i < 1000; i++) {
                executor.execute(new Work(i));

            }
        }
    }

}

class Work implements Runnable{
    int taskid;

    public Work(int taskid){
        this.taskid=taskid;
    }

    @Override
    public void run(){
        System.out.println("Task "+taskid+" executed by "+Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }


}
