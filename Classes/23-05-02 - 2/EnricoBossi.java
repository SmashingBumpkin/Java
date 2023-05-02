
public class EnricoBossi {
    private volatile boolean corre = true;
    //Volatile means that the cache is forced to synchronize with main memory
    //This is used for synchronization in threading.
        //If a loop is running it will be entirely within cache
        //If a different function changes the variable it will change the variable 
        //in RAM. The *volatile* keyword forces the cache to sync with main memory.  

    

    public void run() {
        int i;
        while (corre) {
            for(i=0; i<100; i++){
                System.out.println("Enrico ");
            }
            for(i=0; i<100; i++){
                System.out.println("Bossi ");
            }
        }
        System.out.println("Addi paradiso!");
    }

    public void fermati(){
        this.corre = false;
    }
}
