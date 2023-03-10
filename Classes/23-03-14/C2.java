/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class C2 extends C1 {
    // a subclass

    public int b = 7; // override
    public int fourtytwo = 42; // original field of class C2

    public C2 (int a){
        super(a);
    }
    public C2 (int a, int b, int f) {
        super(a); // calls the constructor of superclass C1
        // what would the difference be with calling super(a, b)?
        this.b = b;
        fourtytwo = f;
    }

    public void blorg () { // original method of class C2
        System.out.println("BLORG");
    }

    public void plus (String s) { // overload
        System.out.println(s);
    }

    public void plus () { // override
        System.out.println("C2: a + b = " + (a + this.b));
    }

    public void myFathersb () { // reads fild b of superclass C1
        System.out.println("note: super b = " + super.b);
    }
}
