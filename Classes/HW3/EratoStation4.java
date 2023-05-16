/**
 * Created by pietrocenciarelli on 06/05/23.
 */
public class EratoStation4 extends Thread {

    public final int prime;
    public EratoStation4 next = null;

    private int buffer;
    private boolean isEmpty = true;

    public EratoStation4 (int prime) {
        this.prime = prime;
    }

    private synchronized int popBuffer () throws InterruptedException {
        // called by this.run

        while (isEmpty)
            wait();
        isEmpty = true;
        notify();
        return buffer;
    }

    public synchronized void pushBuffer (int number) throws InterruptedException {
        // called by the previous station's run

        while (!isEmpty)
            wait();
        isEmpty = false;
        buffer = number;
        notify();
    }

    public void run () {
        try {
            int number;
            while (!isInterrupted()) {
                number = popBuffer();
                if (number % prime != 0 ) {
                    if (next == null) {
                        next = new EratoStation4(number);
                        next.start();
                    }
                    else
                        next.pushBuffer(number);
                }
            }
        }
        catch (InterruptedException e) {
        }
        System.out.print(prime + " ");
        if (next != null)
            next.interrupt();
    }
}
