
public class JimKongUn extends Thread {
    JimKongUn(){

    }
    public void run (){
        int i;

        while (!isInterrupted()){
            for(i=0; i<100; i++){
                System.out.println("Jim " + i);
            }
            for(i=0; i<100; i++){
                System.out.println("Kong " + i);
            }
        }
        System.out.println("Kong BOOM!");
    }

}
