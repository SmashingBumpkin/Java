/**
 * Created by pietrocenciarelli on 24/03/21.
 */
public class TestLists {
    // plays with lists

    public static void main(String[] args) {

        IntList L = new IntList(1, null);
        L.cons(2);
        L.cons(3);
        L.cons(4);

        L.printList();
        System.out.println("head element = " + L.get());

        System.out.println();

        GenericList<Integer> L1 = new GenericList<Integer>(32, null);
        // GenericList<int> GLI = new GenericList<int>(32, null); // no primitive types!

        L1.cons(37);
        L1.cons(38);
        L1.cons(39);

        L1.stampaLista();
        System.out.println("head element = " + L1.get());

        System.out.println();

        GenericList<Boolean> L2 = new GenericList<Boolean>(true, null);
        L2.cons(false);
        L2.cons(false);
        L2.cons(false);

        L2.stampaLista();
        System.out.println("head element = " + L2.get());

        System.out.println();

        GenericList<Object> GLO = new GenericList<Object>(new Object(), null);
        GLO.cons(new Object());

        GLO.stampaLista();
        System.out.println("in testa ho " + GLO.get());
    }
}
