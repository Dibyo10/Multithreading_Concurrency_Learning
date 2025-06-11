package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        try(ExecutorService service= Executors.newSingleThreadExecutor()){
            for (int i = 0; i < 5 ; i++) {
                service.execute(new Task(i));
                
            }
        }
    }


}

class Task implements Runnable{
    int taskid;

    public Task(int taskid){
        this.taskid=taskid;
    }

    @Override
    public void run(){
        System.out.println("Task with ID "+taskid+" being executed by thread "+Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            throw new RuntimeException(e);

        }
    }
}
