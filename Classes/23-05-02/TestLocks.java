public class TestLocks {
    public static void main(String[] args) throws InterruptedException{
        Object o1 = new Object();
        Object o2 = new Object();
        
        Waiter w = new Waiter(o1,o2);
        Notifier n = new Notifier(o1, o2);
        
        w.start();
        Thread.currentThread().sleep(100);
        n.start();
    }
    
}
