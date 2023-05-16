public class EratoStation3 extends Thread {
    public final int prime;
    public EratoStation3 next = null;

    private int buffer;
    private boolean isEmpty = true;

    public EratoStation3(int prime) {
        this.prime = prime;
    }

    private synchronized int popBuffer() throws InterruptedException {
        while (isEmpty){
            System.out.println(prime + " is waiting to pop.");
            wait();
        }
        isEmpty = true;
        notify();
        return buffer;
    }

    public void start() {
    }

    public synchronized void pushBuffer(int number) throws InterruptedException {
        // System.out.println("Thread " + this.number + " is currently working on " + number);
        while (!isEmpty){
            System.out.println(prime + " is waiting to push " + number);
            wait();
        }
        isEmpty = false;
        buffer = number;
        notify();
    }

    public void run() {
        try {
            int number;
            while (!isInterrupted()){
                number = popBuffer();
                if (number % prime != 0){
                    if (next == null){
                        next = new EratoStation3(number);
                        next.start();
                    }
                    else {
                        next.pushBuffer(number);
                    }
                }
            }
        } catch (InterruptedException e){
        }
        System.out.print(prime + " ");
        if (next != null)
            next.interrupt();
    }
}
