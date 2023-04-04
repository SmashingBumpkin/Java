/**
 * Created by pietrocenciarelli on 24/03/21.
 */
public class GenericList <E> {
    // same as IntList, but...
    // generic! ...parameter E stands for the type of the list elems

    private E head;
    private GenericList tail = null;

    GenericList(E head, GenericList tail) {
        this.head = head;
        this.tail = tail;
    }

    public E get () {
        return head;
    }

    public void cons (E e) {
        tail = new GenericList(head, tail);
        head = e;
    }

    public void stampaLista () {
        System.out.print(head + " ");
        if (tail == null)
            System.out.println();
        else
            tail.stampaLista();
    }
}
