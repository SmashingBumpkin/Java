/**
 * Created by pietrocenciarelli on 31/03/21.
 */

 public class Gen1 <E> {

    public void myPrint (E x) {
        System.out.println(x);
    }

    public static void main(String[] args) {

        Gen1<String> gs = new Gen1<>();
        gs.myPrint("gnat");
        // gs.myPrint(new Integer(77));


        Gen1 gr = new Gen1(); // raw type
        // seems to behave as if it were Gen1<Object>
        gr.myPrint("gnat");
        gr.myPrint(new Integer(77));

        gs = gr;
        gr = gs;

    }
}
