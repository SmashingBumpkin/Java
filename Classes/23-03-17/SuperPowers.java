package first;
import second.Powers;

/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class SuperPowers extends Powers {

    // extends a class of a different package

    public void printPowers () {
        // shows the difference between protected and package-private

        System.out.println(eleventh); // OK: protected field!
        // System.out.println(twelfth); // NO: package-private field!
    }
}
