package PracticeQuestions;

public class SumTo100 {
    static int count=0;
    static final Object lock=new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 1000 ; i++) {
                    count++;

                }
            }

        });
        Thread t2=new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 1000 ; i++) {
                    count++;

                }
            }

        });
        Thread t3=new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 1000 ; i++) {
                    count++;

                }
            }

        });
        Thread t4=new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 1000 ; i++) {
                    count++;

                }
            }

        });
        Thread t5=new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 1000 ; i++) {
                    count++;

                }
            }

        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        t5.start();
        t5.join();

        System.out.println(count);
    }
}
