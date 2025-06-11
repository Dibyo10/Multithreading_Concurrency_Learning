import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdderSubtractor {
    public static void main(String[] args) {
        int count=0;
        final Object lock=new Object();
        try(ExecutorService exe= Executors.newFixedThreadPool(2)){
            for (int i = 0; i < 100; i++) {
                synchronized (lock){
                    exe.execute(new Adder(count++));
                }
                synchronized (lock){
                    exe.execute(new Subtractor(count--));
                }
            }

        }

        System.out.println(count);
        System.out.println("Process done..");

    }

}

class Adder implements Runnable{
    int n;

    public Adder(int n){
        this.n=n;
    }
    @Override
    public void run(){
        n++;
        System.out.println("Value incremented to "+n);

    }
}

class Subtractor implements Runnable{
    int sub;


    public Subtractor(int sub){
        this.sub=sub;
    }

    @Override
    public void run(){
        sub--;
        System.out.println("Value decremented to "+sub);

    }

}
