/**
 * Created by pietrocenciarelli on 22/03/21.
 */
public class State {

    public String name; // name of the state
    public String currency; // name of its currency
    public int reserves; // gold reserves
    public int amount = 0; // total value of minted coins

    public class Coin { // inner class
        //Inner classes are nothing to do with sub-classes (which involve inheritance)
        //Inner classes do not inherit anything
        int value;

        public Coin (int value) {
            this.value = value; // this denotes the inner object
            (State.this).amount = (State.this).amount + value;
            // State.this denotes the outer object
        }

        public void printValue () {
            System.out.println("Bank of " + name);
            System.out.println(State.this.amount);
            System.out.print( value + " " + currency);
            System.out.println(" (value in gold: " + (State.this).valueInGold(this) + " Kg)");
        }
    }

    public State (String name, String currency, int reserves) {
        this.name = name;
        this.currency = currency;
        this.reserves = reserves;
    }

    public int valueInGold (Coin m) {
        return (reserves/amount) * m.value;
    }

    public Coin mint (int v) {
        return new Coin(v);
    }

}
