/**
 * Created by pietrocenciarelli on 22/03/21.
 */
public class TestStates {
    public static void main(String[] args) {
        // finanza creativa
        State russia = new State ("Russia","Ruble",100000);

        State switzerland = new State ("Switzerland","Franc",10000);
        System.out.println(switzerland.name);
        // switzerland.Coin f100;
		/* Although Coin is a *non* static member of State, it is nevertheless
		 * referred to by prefixing it with the class name: */

        State.Coin steves = switzerland.mint(100); // minted in Switzerland!
        steves.printValue();
        // steves = russia.mint(50);
        // steves.printValue();
        // steves = russia.mint(500);
        // steves.printValue();

        // State.Coin big_phil = new State.Coin(77); // errore: no enclosing type!
		/* State.Coin is indeed a type, but it cannot be used to call a constructor
		 * because... what state?! ...there is no outer object here! */

        State.Coin big_phil = switzerland.new Coin(100); // minted here, in foreign land!
        big_phil.printValue();
		/* notice: f2 is worth 100 francs, just like steves. However, because of inflation,
		 * its value in gold is now half the the value steves had before, ! */
    }
}
