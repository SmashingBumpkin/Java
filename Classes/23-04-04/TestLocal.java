/**
 * Created by pietrocenciarelli on 22/03/21.
 */
public class TestLocal {

    //Explain why you can't access a non-final local variable

    int attr1 = 7;

    {int attr2 = attr1;} // this is a block, but not a statement!
    // A block is a group of zero or more statements between balanced braces
    // and can be used anywhere a single statement is allowed
    int attr3 = attr1; // attr1 is fine to use
    // int attr4 = attr2; // but attr2 is out of its scope

    class Inner { // inner class
    }

    public int m () {

        int locvar = 3;

        /* local classes have only access to "effectively final" local variables
         */

        class LocalInner { // a class local to method m()

            int q () {
                System.out.println(attr1); // ok, access to a member of the enclosing class
                System.out.println(locvar); // ok, y is "effectively final"
                return 42;
            }

        }
        // locvar++; // locvar is not effectively final anymore
        return new LocalInner().q(); // weirdly enough, this would still be ok if q() were private!

        // what if m() returned an object of *local* type LocalInner!?
        //return new LocalInner(); // must change the return type of m()
    }

    public static void main(String[] args) {

        Inner I;
        // LocalInner J; // LocalInner only visible within the body of m()

        System.out.println(new TestLocal().m());
    }
}
