/**
 * Created by pietrocenciarelli on 14/04/21.
 */
public class NamedThread extends Thread {

    public static NamePrinter NP = new NamePrinter();

    public NamedThread(String name) {
        super(name);
    }

    public void run () {
        NP.printName();
    }
}
