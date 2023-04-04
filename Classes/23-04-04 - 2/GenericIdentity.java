/**
 * Created by pietrocenciarelli on 24/03/21.
 */
public class GenericIdentity {
    // *non* generic class with a generic method

    public <E> E identity (E x) {
        return x;
    }

    public static void main(String[] args) {

        GenericIdentity ggg = new GenericIdentity();
        Integer three = new Integer(8);
        String ciao = new String("ciao");

        System.out.println(three == ggg.<Integer>identity(three));
        System.out.println(ciao == ggg.<String>identity(ciao));
        // System.out.println(three == ggg.<String>identity(three));

        System.out.println(new String("ciao") == ggg.<String>identity(new String("ciao")));
        System.out.println(new String("ciao").equals(ggg.<String>identity(new String("ciao"))));
        System.out.println((new Object().equals(new Object())));
    }
}
