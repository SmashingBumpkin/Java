/**
 * Created by pietrocenciarelli on 14/03/21.
 */
public class TestVariables {

    public static boolean cmpVars(IntVar x, IntVar y) {
        // runs a simple test on int vars

        x.assign(7);
        y.assign(7);
        return x.get() == y.get();
    }

    public static void main(String[] args) {
        // creates two IntVars and compares them

        IntVar v1 = new IntVar1();
        // v1.extraJunk(); // no way!

        IntVar v2 = new IntVar2();

        if (cmpVars(v1, v2))
            System.out.println("can't distinguish them!");
    }
}
