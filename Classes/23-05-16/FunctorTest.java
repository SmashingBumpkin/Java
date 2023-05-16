import java.util.function.Function;

/**
 * Created by pietrocenciarelli on 10/05/21.
 */
public class FunctorTest {

    static <T> void printLink (FunctorLink<T> l) { // prints a list

        if (l == null)
            System.out.println();
        else {
            System.out.print(l.val + " ");
            printLink(l.next);
        }
    }

    public static void main(String[] args) {

        FunctorLink<Integer> chain0 = new FunctorLink(new Integer(5), new FunctorLink(new Integer (4), null));
        FunctorLink<Integer> chain1 = new FunctorLink(new Integer(6), new FunctorLink(new Integer (9), chain0));
        printLink(chain1); // prints a chain of integers

        Function <Integer, Boolean> F = (Integer i) -> new Boolean(i%2 == 0); // true if even, false ow
        FunctorLink<Boolean> chain2 = chain1.fmap(F);
        // builds a chain of booleans chain2,
        // the i-th element of which is true if the i-th element of chain1 is even, false otherwise
        printLink(chain2);
    }
}
