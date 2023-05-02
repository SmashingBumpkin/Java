public class ItsStatic {
    public static void main(String[] args) throws InterruptedException {
        // this.wait();
        //This doesn't make sense since there is no "this", it's a static object
        
        new Object().wait();
        /*
        Object x = new Object();
        synchronized (x) {
            x.wait();
        }
         */
    }
    
}
