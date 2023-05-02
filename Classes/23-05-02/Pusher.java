/**
 * Created by pietrocenciarelli on 18/04/21.
 */
public class Pusher extends Thread {
    // pushes a value in a stack

    private Stack pila;
    private int valore;

    public Pusher(Stack pila, int valore) {
        this.pila = pila;
        this.valore = valore;
    }

    @Override
    public void run() {
        try {
            pila.push(valore);
        } catch (InterruptedException e) {
            System.out.println("was sleeping...");
        }
    }
}
