
public class RunnableThreadExample {
    public static void main(String[] args) {

        Thread one=new Thread(new ThreadOne());
        Thread two=new Thread(new ThreadTwo());
        Thread three=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 3 : "+i);

            }
        });
        one.start();
        two.start();
        three.start();
        System.out.println("Done execution");
    }
}
class ThreadOne implements Runnable{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Thread 1 : "+i);
        }
    }
}

class ThreadTwo implements Runnable{
    @Override
    public void run(){
        for(int i=0;i<15;i++){
            System.out.println("Thread 2 : "+i);
        }
    }
}