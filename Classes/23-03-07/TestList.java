/**
 * Created by pietrocenciarelli on 03/03/21.
 */
public class TestList {
    public static void main(String[] args) {
        // plays with lists

        IntList l1 = new IntList(1, new IntList(9, new IntList(5,null)));
        l1.printList(4);
        IntList l2 = new IntList(3, new IntList(7, null));
        l2.printList(20);
        l1.concat(l2); // concats l2 and l1; now l2 has 5 elements
        
        l1.addontop(4);
        l1.printList(5);
        l2.printList(50);

        l1.loop(); // now l1 is circular. Is l2 circular too?
        l2.printList(15); // ...do you understand why?!
        System.out.print("    ");
        l1.printList(13);
    }
}
