import java.util.Scanner;

public class PrimeNumberUsingThreads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter upper limit (n): ");
        int n = sc.nextInt();
        System.out.print("Enter number of threads: ");
        int noOfThreads = sc.nextInt();

        Thread[] threads = new Thread[noOfThreads];

        int rangeSize = n / noOfThreads;
        int remainder = n % noOfThreads;

        int start = 1;

        for (int i = 0; i < noOfThreads; i++) {
            int end = start + rangeSize - 1;


            if (i == noOfThreads - 1) {
                end = n;
            }

            Check task = new Check(start, end);
            threads[i] = new Thread(task);
            threads[i].start();

            start = end + 1;
        }

        for (int i = 0; i < noOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All threads finished.");
    }
}

class Check implements Runnable {
    private int start, end;

    public Check(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime (checked by " + Thread.currentThread().getName() + ")");
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
