package PracticeQuestions;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
    public static void main(String[] args) {
        ArrayList<String> products=new ArrayList<>();
        for(int i=0;i<10;i++){
            products.add("Product");
        }
        ProduceConsume task=new ProduceConsume(10,products);
        ExecutorService ex=Executors.newCachedThreadPool();

        ex.submit(()->{
            try{
                task.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        ex.submit(()->{
            try{
                task.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        ex.submit(()->{
            try{
                task.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        ex.submit(()->{
            try{
                task.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });



    }
}
class ProduceConsume{
    ArrayList<String> products;
    int max;
    int count;
    final Object lock=new Object();

    ProduceConsume(int max,ArrayList<String> products){
        this.products=products;
        this.max=max;

    }
    public void produce() throws InterruptedException {
        while(true){
            synchronized (lock){
                if(products.size()==max){
                    System.out.println("Container full..waiting to be consumed");
                    try {

                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    products.add("Product");
                    System.out.println("Another Product produced.. and current size "+products.size()+" by "+Thread.currentThread().getName());
                    lock.notifyAll();


                }
            }
            Thread.sleep(1000);

        }

    }
    public void consume() throws InterruptedException {
        while(true){
            synchronized (lock){
                if(products.size()==0){
                    System.out.println("Container empty..waiting to be produced by "+Thread.currentThread().getName());
                    try {

                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    products.removeFirst();
                    System.out.println("Another Product consumed.. and current size "+products.size()+" by "+Thread.currentThread().getName());
                    lock.notifyAll();


                }
            }
            Thread.sleep(1000);
        }
    }

}