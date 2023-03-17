package third;

import first.SuperPowers;
import second.Powers;

/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class D1 {
    // a class
    Powers d1s_power = new Powers(); 
    first.SuperPowers d1s_superpower = new SuperPowers(); //Fully qualified package, imported from first.SuperPowers

    public void printSomething () {
        System.out.println("D1");
    }
}
