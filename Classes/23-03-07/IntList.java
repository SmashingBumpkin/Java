public class IntList {
    //Lists of integers

    public int head;
    public IntList tail;

    IntList(int head, IntList tail){
        this.head = head;
        this.tail = tail;
    }

    IntList(int head){
        this(head, null);
    }

    IntList(IntList tail){
        this(0, tail);
    }

    public void printList(int n){
        //prints the first n elements of the list
        if (n <= 0){
            System.out.println();
            return;
        }
        System.out.print(head + " ");

        if (tail == null)
            System.out.println();
        
        else 
            tail.printList(n-1);
        
    }

    public void concat (IntList l){
        //appends list l to this list
        if (tail == null)
            tail = l;
        else tail.concat(l); //recursively calls concat on tail
    }

    public void addontop(int arg){
        tail = new IntList(head,tail);
        head = arg;
    }

    public void loop (){
        IntList DEEZNUTZ = this;
        concat(DEEZNUTZ);
    }

    public void sort() {
        
    }
}