/**
 * Created by pietrocenciarelli on 14/04/21.
 */
public class NamePrinter {

    // It provides a printName method which prints 70 + 70 times
    // the name of the current thread, unsynchronized in the first
    // chunk, synchronized in the second

    // public synchronized void printName () {
    public void printName () {
        for (int i = 0; i < 70; i++) {
            System.out.println("I am " + Thread.currentThread().getName());
        }
        // synchronized (new Object()) {
        synchronized (this) {
            for (int j = 0; j < 70; j++) {
                System.out.println("... and I print " + Thread.currentThread().getName());
            }
        }
    }
}
