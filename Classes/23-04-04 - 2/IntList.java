/**
 * Created by pietrocenciarelli on 24/03/21.
 */
public class IntList { // the usual stuff

    private int head;
    private IntList tail = null;

    IntList(int head, IntList tail) {
        this.head = head;
        this.tail = tail;
    }

    public int get () { // gets the head of the list
        return head;
    }

    public void cons (int e) { // inserts a new head element
        // tail = this; // try this!
        tail = new IntList(head, tail);
        head = e;
    }

    public void printList () { // stampa la lista
        System.out.print(head + " ");
        if (tail == null)
            System.out.println();
        else
            tail.printList();
    }
}
