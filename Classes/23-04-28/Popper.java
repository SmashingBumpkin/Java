/**
 * Created by pietrocenciarelli on 14/04/21.
 */
public class Popper extends Thread {

    private ArrayStack stack;

    public Popper (ArrayStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            System.out.println(stack.pop());
        } catch (EmptyStackException e) {
            System.out.println("omelette!");
        } catch (InterruptedException e) {
            System.out.println("Was sleeping...");
        }
    }
}
