/**
 * Created by pietrocenciarelli on 14/04/21.
 */
public class DeadLock {
        /*
    Deliberately creates a deadlock: two dead man walking try to
    obtain locks over two monitors, but they do it in different order
    Using sleep (see DeadManWalking) to make deadlock happen!
    */

    public static void main(String[] args) {

        Object monitor1 = new Object();
        Object monitor2 = new Object();

        DeadManWalking snapo = new DeadManWalking(monitor1, monitor2);
        snapo.setName("Snapo");

        DeadManWalking raz = new DeadManWalking(monitor2, monitor1);
        raz.setName("Raz");

        snapo.start();
        raz.start();
    }
}
