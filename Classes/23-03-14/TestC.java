/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class TestC {
    public static void main(String[] args) {
        // plays with hierarchy
        C2 jeff = new C2();
        jeff.floodge();

        C1 x = new C1(3);
        x.ciao("hallo x! a = 3, b = " + x.b);
        System.out.println("...note: b has default value " + x.b);
        x.plus();

        C2 y = new C2(30, 40, 50);
        y.ciao("hallo y! a = 30, b = 40"); // inherited method

        System.out.println("fourtytwo = " + y.fourtytwo); // original field of C2
        y.blorg(); // original method of C2

        y.plus("overloaded plus"); // overloading
        y.plus(); // overriding
        System.out.println("...because b = " + y.b);

        y.myFathersb();

        C1 z = new C2(777, 888, 999);
        z.ciao("hallo z! a = 777, b = 888, fourtytwo = 999");

        // System.out.println("fourtytwo = " + z.fourtytwo); // a field of C2 (NO!)
        //  z.blorg(); // NO!
        //  z.blah(100); // NO!

        z.plus(); // the plus method of C2 is executed
        System.out.println("... although b = " + z.b); // the b of C1 is read
        // in a slogan: methods are dispatched dynamically, attributes statically
    }
}
