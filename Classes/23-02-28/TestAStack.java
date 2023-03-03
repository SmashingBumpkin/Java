/**
 * Created by pietrocenciarelli on 24/02/21.
 */

public class TestAStack {

    public static void main (String[] args) {
        // playing with stacks

        ArrayStack2 SS = new ArrayStack2(2);
        System.out.println("ceated a stack of length " +
                SS.lunghezza());
        try {
            SS.push(6);
            SS.push(3);
            // SS.push(33); // exception!
            SS.pop();
            SS.pop();
            // SS.pop(); // exception!
        }
        catch (FullStackException e) {
            System.out.println("Full stack exception while pushing " + e.value);
        }
        catch (EmptyStackException e) {
            System.out.println("Empty stack exception!");
        }
    }
}
