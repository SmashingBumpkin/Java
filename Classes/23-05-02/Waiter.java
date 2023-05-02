
public class Waiter extends Thread {
    Object o1;
    Object o2;

    public Waiter (Object o1, Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run(){
        synchronized(o1) {
            synchronized(o2){
                try {
                    o2.wait();
                } catch (InterruptedException e) {}
                }
            }
        }
    }
