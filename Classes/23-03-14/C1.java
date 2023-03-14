/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class C1 {
    // just a class

    public int a = 1;
    public int b = 2;
    
    public C1 () {
    }

    public C1 (int a) {
        this.a = a;
    }

    public C1 (int a, int b) {
        this(a); //calls other constructor 
        this.b = b;
    }

    public void ciao (String s) {
        System.out.println(s);
    }

    public void plus () {
        System.out.println("C1: a + b == " + (a + b));
    }
}
