package ExecutorService;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
       try(ExecutorService executor= Executors.newCachedThreadPool()){
           for (int i = 0; i < 100 ; i++) {
               Future<String> res=executor.submit(new Number(i));

               String ans=res.get();

               if(!ans.isEmpty()){
                   System.out.println(ans);
               }

           }
       }

    }
}

class Number implements Callable<String>{
    int n;

    Number(int n){
        this.n=n;
    }
    @Override
    public String call() throws Exception{

        if(isPrime(n)){
            return (n+" is Prime by "+Thread.currentThread().getName());
        }else{
            return("");
        }
    }

    public boolean isPrime(int n){
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;

    }
}
