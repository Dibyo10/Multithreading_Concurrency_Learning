package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountSum100 {
    public static void main(String[] args) {
        int sum=0;
        try(ExecutorService executor= Executors.newFixedThreadPool(100)){
            for (int i = 0; i < 100; i++) {
                executor.execute(new Adder(sum++));


            }
        }
        System.out.println(sum);
        /*for (int i = 0; i <100 ; i++) {
            sum++;

        }
        System.out.println(sum);*/


    }
}

class Adder implements Runnable{
    int sum=0;

    public Adder(int sum){
        this.sum=sum;
    }
    @Override
    public void run(){

        System.out.println(Thread.currentThread().getName()+" used");


    }
}
