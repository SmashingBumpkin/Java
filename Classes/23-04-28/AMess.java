/**
 * Created by pietrocenciarelli on 14/04/21.
 */
public class AMess {
    /*
    Two threads pop over a stack. If they do not synchronize
    (see ArrayStack) they may extract the same element, and one
    element may be lost!
    */

    public static void main(String[] args) throws EmptyStackException, InterruptedException, FullStackException {

        ArrayStack S = new ArrayStack(10);

        Popper p1 = new Popper(S);
        p1.setName("Snapo");

        Popper p2 = new Popper(S);
        p2.setName("Raz");

        S.push(33);
        S.push(42);

        p1.start();
        p2.start();

        // Thread.currentThread().sleep(500);
        // S.pop();
    }
}
