public class DaemonUser {
    public static void main(String[] args) {

        Thread daemon=new Thread(new Daemon());
        Thread user=new Thread(new User());

        daemon.setDaemon(true);

        daemon.start();
        user.start();

    }
}
class Daemon implements Runnable{
    @Override
    public void run(){
        int count=0;
        while(count<500){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon running..");
        }

    }
}

class User implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User thread done");


    }

}
