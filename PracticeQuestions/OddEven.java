package PracticeQuestions;

public class OddEven {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter(1, 30); // print 1 to 30

        Thread oddThread = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        oddThread.start();
        evenThread.start();
    }
}

class SharedPrinter {
    private int number;
    private final int max;
    private final Object lock = new Object();

    public SharedPrinter(int start, int max) {
        this.number = start;
        this.max = max;
    }

    public void printOdd() throws InterruptedException {
        while (number <= max) {
            synchronized (lock) {
                if (number % 2 == 0) {
                    lock.wait();
                } else {
                    System.out.println("Odd: " + number + " by " + Thread.currentThread().getName());
                    number++;
                    lock.notify();
                }
            }
        }
    }

    public void printEven() throws InterruptedException {
        while (number <= max) {
            synchronized (lock) {
                if (number % 2 != 0) {
                    lock.wait();
                } else {
                    System.out.println("Even: " + number + " by " + Thread.currentThread().getName());
                    number++;
                    lock.notify();
                }
            }
        }
    }
}
