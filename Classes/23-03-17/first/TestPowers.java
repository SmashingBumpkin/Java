package first;
import second.Powers;

/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class TestPowers {
    public static void main(String[] args) {

        // plays with access modifiers

        Powers p = new Powers();
        System.out.println(p.ninth); // OK: public field!
        // System.out.println(p.tenth); // clearly NOT: private field!
        // System.out.println(p.eleventh); // NO: protected field!
        // System.out.println(p.twelfth); // NO: "package-private" field!


        SuperPowers ps = new SuperPowers();
        ps.printPowers(); // prints the eleventh power but cannot access the twelfth
    }
}
