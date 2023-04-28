/**
 * Created by pietrocenciarelli on 14/04/21.
 */
public class TestPrinter {
    public static void main(String[] args) {
        NamedThread snapo = new NamedThread("snapo");
        NamedThread raz = new NamedThread("raz");
        snapo.start();
        raz.start();
    }
}
