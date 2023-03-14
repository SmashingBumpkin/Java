/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class C2 extends C1 {
    // a subclass

    public int b = 7; // override
    public int fourtytwo = 42; // original field of class C2

    public C2 (int a){
        super(a); //uses the constructor from the parent class
    }
    public C2 (int a, int b, int f) {
        super(a); // calls the constructor of superclass C1
        // what would the difference be with calling super(a, b)?
        this.b = b;
        fourtytwo = f;
    }
    public C2 () {
        //by default calls the the default constructor 
        //of super class
        //defaults to all default values for C2 and C1
        //Default values of C2 overwrite C1
    }

    public void blorg () { // original method of class C2
        System.out.println("BLORG");
    }

    public void floodge () { // original method of class C2
        System.out.println("PRINTING this a, this b, super b, this fourthyeyhf");
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(super.b);
        System.out.println(this.fourtytwo);
    }

    public void plus (String s) { // overload
        //Plus method is defined in the super class with one variable
        //This method overloads it, as it takes a different number 
        //of variables as the super method
        System.out.println(s);
    }

    public void plus () { // override
        System.out.println("C2: a + b = " + (a + this.b));
    }

    public void myFathersb () { // reads fild b of superclass C1
        System.out.println("note: super b = " + super.b);
    }
}
