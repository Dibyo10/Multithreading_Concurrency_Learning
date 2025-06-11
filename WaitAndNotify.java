public class WaitAndNotify {

    private static final Object lock=new Object();


    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread t2=new Thread(()->{
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        t1.start();
        t2.start();
    }
    private static void one() throws InterruptedException{
        synchronized (lock){
            System.out.println("Method 1 says hello");
            lock.wait();
            System.out.println("Back again in method one");
        }
    }

    private static void two() throws InterruptedException{
        synchronized (lock){
            System.out.println("Method 2 says hello");
            lock.notify();
            System.out.println("Hello from method two even after notifying");
        }
    }

}
