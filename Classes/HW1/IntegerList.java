public class IntegerList {
    public int head;
    public IntegerList tail;
    private boolean empty = true;

    IntegerList(int head, IntegerList tail){
        //Constructor
        this.head = head;
        this.tail = tail;
        this.empty = false;
    }
    IntegerList(int head){
        //Constructor
        this.head = head;
        this.tail = null;
        this.empty = false;
    }

    IntegerList(){
    }

    public void add(int element){
        //adds int on top of list
        if (empty){
            head = element;
            empty = false;
        }
        else if (tail == null)
            tail = new IntegerList(element);
        else
            tail.add(element);
    }

    public void add (int index, int element) throws OutOfBoundsException{
        //adds int at position index
        int siz = size();
        if (index >= siz){
            throw new OutOfBoundsException(siz,index);
        }
        else
            addHelper(index, element);
    }

    private void addHelper (int index, int element) throws OutOfBoundsException{
        //adds int at position index
        if (index == 0){
            tail = new IntegerList(head,tail);
            head = element;
        }
        else
            tail.addHelper(--index, element);
    }

    public void remove(int index) throws OutOfBoundsException {
        //removes entry at position index
        int siz = size();
        if (index >= siz){
            throw new OutOfBoundsException(siz,index);
        }
        else if (siz == 1){
            empty = true;
        }
        else {
            remove_helper(index);
        }
    }

    private void remove_helper(int index) throws OutOfBoundsException {
        //removes entry at position index
        if (index == 0){
            head = tail.head;
            tail = tail.tail;
        }
        else if (index == 1 && tail.tail == null)
            tail = null;
        else
            tail.remove_helper(--index);
    }

    public void sort() {
        sortHelper(false, this);
    }
    
    private void sortHelper(boolean have_sorted, IntegerList top_level_list) {
        if (tail == null){
            if (have_sorted == true){
                top_level_list.sortHelper(false, top_level_list);
            }
            else {
                return;
            }
        }
        else {
            if (head <= tail.head){
                tail.sortHelper(have_sorted, top_level_list);
            }
            else {
                int temp = head;
                head = tail.head;
                tail.head = temp;
                tail.sortHelper(true, top_level_list);
            }
        }
    }

    public void printList(){
        if (tail != null){
            System.out.print(head + " ");
            tail.printList();
        }
        else
            System.out.println(head);
    }

    public int size(){
        if (tail == null){
            return 1;
        }
        return 1 + tail.size();
    }
}
