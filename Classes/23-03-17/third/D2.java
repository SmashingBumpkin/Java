package third;

import third.D1;

/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class D2 extends D1 {
	/* a subclass */

    public void printSomething () {
        System.out.println("D2");
    }

    public void blorg () {
        super.printSomething();
        this.printSomething();
    }
}
