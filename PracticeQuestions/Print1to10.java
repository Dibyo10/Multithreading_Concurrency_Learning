package PracticeQuestions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Print1to10 {
    public static void main(String[] args) {
        int n=20;
        try(ExecutorService ex= Executors.newFixedThreadPool(n)){
            for (int i = 1; i <=n ; i++) {
                ex.execute(new Print(i));

            }
        }
    }
}
class Print implements Runnable{
    int n;

    Print(int n){
        this.n=n;
    }
    @Override
    public void run(){
        System.out.println(n+" by "+Thread.currentThread().getName());
    }
}
