/**
 * Created by pietrocenciarelli on 18/04/21.
 */
public class TestStack {
        /*
    testa l'implementazione sbagliata e quella corretta
    (con wait e notify) di una pila in regime di concorrenza
    */

    public static void main(String[] args) throws InterruptedException {

        // Stack S = new UglyArrayStack(2); // things *may*
        // work fine (try it out a few times), but most likely
        // an ArrayIndexOutOfBoundsException is raised.

        Stack S = new BeautifulArrayStack(2);

        Pusher pu1 = new Pusher(S,1);
        Pusher pu2 = new Pusher(S,2);
        Pusher pu3 = new Pusher(S,3);
        Pusher pu4 = new Pusher(S,4);
        Pusher pu5 = new Pusher(S,5);

        Popper po1 = new Popper(S);
        Popper po2 = new Popper(S);
        Popper po3 = new Popper(S);

        pu1.start();
        pu2.start();
        pu3.start();
        pu4.start();
        pu5.start();

        Thread.currentThread().sleep(200);

        po1.start();
        po2.start();
        po3.start(); // commenting this out makes a pusher wait forever
        // note: the whole program terminates when all (launched) threads are done!
    }
}
