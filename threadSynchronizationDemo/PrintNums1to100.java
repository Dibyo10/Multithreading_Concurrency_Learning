package threadSynchronizationDemo;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintNums1to100 {
    public static void main(String[] args) {

        for(int i=0;i<100;i++){
            Print print = new Print(i);
            Thread t=new Thread(print);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



    }

}

class Print implements Runnable{
   int count=0;


   public Print(int count){
       this.count=count;

   }
   @Override
    public synchronized void run(){

       System.out.println(count+" by "+Thread.currentThread().getName());



   }



}
