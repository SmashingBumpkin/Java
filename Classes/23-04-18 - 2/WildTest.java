/**
 * Created by pietrocenciarelli on 31/03/21.
 */
public class WildTest {


    public void extMethod (Gen<? extends C2> x) {
        // may be applied to a Gen<T> for any subtype T of C2;

        System.out.println("I extend, therefore I work fine!");
    }

    public void supMethod (Gen<? super C2> x) {
        // may be applied to a Gen<T> for any supertype T of C2;

        System.out.println("I an super, therefore I work fine!");
    }

    public static void main(String[] args) {
        // test wildcard

        // ? y; // "?" is not a type!
        Gen<?> x;
        Gen<String> gs = new Gen<String>();
        x = gs; // Gen<String> is a subtype of Gen<?>
        // Gen<Object> go = new Gen<String>(); // ...but not of Gen<Object>
        Gen<String> steve;
        steve = new Gen<String>();

        // x = new Gen<?>(); // cannot create an instance of Gen<?>
        System.out.println("about to print  x");
        x.printGnat();
        System.out.println("Just printed x");
        //x.printParam("green");
		 /* the compiler ignores what's in x, so it is unable to tell
		 *  if printParam would be capable of printing a String
		 */

        x.printParam(null); // ...however this you can do :-/ oh well!!
        steve.printParam("Jeff"); 
        Gen<C1> y = new Gen<C1>();
        Gen<C2> z = new Gen<C2>();
        Gen<C3> w = new Gen<C3>();

        WildTest t = new WildTest();

        // t.extMethod(y); // C1 does not extend C2
        t.extMethod(z);
        t.extMethod(w);

        t.supMethod(y);
        t.supMethod(z);
        // t.supMethod(w); // C3 is not a supertype of C2
    }
}
