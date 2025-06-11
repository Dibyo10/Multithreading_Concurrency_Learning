package PracticeQuestions;

public class ThreadABC {
    public static void main(String[] args) {
        Thread one=new Thread(()->{
            System.out.println("one done");
        });
        Thread two=new Thread(()->{
            System.out.println("two done");
        });
        Thread three=new Thread(()->{
            System.out.println("three done");
        });



        try {
            one.start();
            one.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            two.start();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            three.start();
            three.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
