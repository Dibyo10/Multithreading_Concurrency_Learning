public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" says hi!!");
        System.out.println(Thread.currentThread().getPriority());




        Thread one=new Thread(()->{
            System.out.println("Thread one says hi..");
            System.out.println(Thread.currentThread().getPriority());
        });

        one.setPriority(Thread.MAX_PRIORITY);
        one.start();

    }
}
