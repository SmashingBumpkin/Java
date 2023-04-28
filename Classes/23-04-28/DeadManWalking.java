/**
 * Created by pietrocenciarelli on 14/04/21.
 */
public class DeadManWalking extends Thread {
    // Two locks nested on different monitors

    Object o1, o2;

    public DeadManWalking (Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void run() {
        synchronized (o1) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ok I'm ready to go...");
            synchronized (o2) {
                System.out.println("I am " + getName() + " and I join you in the fight!");
            }
        }
    }
}
