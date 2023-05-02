
public class RonaldDrump implements Runnable{
    RonaldDrump(){
    }
    public void run() {
        int i;
        // while (!isInterrupted()){
        while (!Thread.currentThread().isInterrupted()){
            for(i=0; i<100; i++){
                System.out.println("Ronald " + i);
            }
            for(i=0; i<100; i++){
                System.out.println("Drump "+ i);
            }
        }
        System.out.println("Drump BOOM!");
    }

}
