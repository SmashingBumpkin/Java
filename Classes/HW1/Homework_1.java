/**
 * Created by pietrocenciarelli on 14/03/22.
 */

 public class Homework_1 {

    /* Implementation of integer lists.
    Implement classes IntegerList and OutOfBoundsException
    in such a way that the following main produces the output
    specified below. The add(int element) adds element on top
    of the list; add(int index, int element) adds element in
    the index-th position (as usual, positions start with 0);
    if no such a position exists, an OutOdBoundsException is
    raised. Method remove(int index) removes the index-th
    element of the list (may raise the exception too). Method
    sort(), sorts the list.
     */

    public static void main(String[] args) {

        IntegerList l = new IntegerList();
        try {
            l.add(66);
            l.add(40);
            l.add(44);
            l.remove(0);
            l.remove(1);
            l.add(88);
            l.add(81);
            l.printList();
            l.add(2, 20);
            l.add(0, 66);
            l.printList();
            System.out.println("current size: " + l.size());
            l.add(6, 990);
            l.add(100);
            l.printList();
        }
        catch (OutOfBoundsException e) {
            e.printException();
        }

        l.sort();
        l.printList();
    }
    /* Should print:
    40
    66 40 88 20 81
    current size: 5
    OutOfBoundsException: Index: 6, Size: 5
    20 40 66 81 88
     */
}
