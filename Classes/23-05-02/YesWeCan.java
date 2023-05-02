/**
 * Created by pietrocenciarelli on 18/04/21.
 */
public class YesWeCan {

  /* A o.wait, o.notify or o.notifyAll can only be called by a
 * thead holding a lock on object o. This cannot be checked at compile
 * time! Violation causes an IllegalMonitorStateException.
 */

    public synchronized void m1 () throws InterruptedException {
        m2();
    }

    public void m2 () throws InterruptedException {
        wait(); // no synchronization! will it cause an IllegalMonitorStateException?
        // ... it depends on whether the current thread will (or won't)
        // hold a lock on this!
    }

    public static void main(String[] args) throws InterruptedException {
        YesWeCan ywc = new YesWeCan();
        // ywc.m2(); // no: IllegalMonitorStateException is raised
        ywc.m1(); //ok!
        // ... the program goes catatonic, as one would expect,
        // but no IllegalMonitorStateException is raised.
    }
}
