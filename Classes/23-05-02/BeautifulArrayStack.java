/**
 * Created by pietrocenciarelli on 18/04/21.
 */
public class BeautifulArrayStack implements Stack {

    /* it implements the ADT of stacks of integers in a
    concurrent setting. It solves the problem discussed
    in UglyArrayStack by using wait (and notifyAll).
    */

    private int[] stk;
    private int top = -1;

    BeautifulArrayStack(int l) {
        stk = new int[l];
    }

    public boolean isEmpty () {
        return top == -1;
    }

    public boolean isFull () {
        return top == stk.length -1;
    }

    public synchronized void push (int v) throws InterruptedException {
        // pushes an int on top of the stack if there is room
        // for it, otherwise it *waits* and then tries again.

        while (isFull()) {
            System.out.println("Pusher waiting...");
            // Thread.sleep(100);
            wait(); //Wait is special, while the program is "waiting" it 
                    //releases the key to the synchronization
        }
        System.out.println("pushing " + v);
        top = top + 1;
        stk[top] = v;
        notify(); // why not just notify()?
    }


    public synchronized int pop () throws InterruptedException {
        // pops and returns the top element if it exists,
        // otherwise it *waits* and then tries again.

        while (isEmpty()){
            System.out.println("Popper waiting...");
            Thread.sleep(100);
            wait();
        }
        int result = stk[top];
        System.out.println("popping " + result);
        top = top - 1;
        notify(); // why not just notify()?
                        //notify() might wake up the wrong thread (eg pop())
                        //They will be unable to pop, so they go back to sleep
                        //But nobody else is awake to take the key
                        //With notifyAll() any pushers will definitely be notified.
        return result;
    }
}
