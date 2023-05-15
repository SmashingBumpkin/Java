import java.util.ArrayList;
import java.util.List;

public class EratoStation extends Thread {
    private final int number;
    private EratoStation nextStation = null;
    private List<Integer> buffer = new ArrayList<>();
    private volatile boolean running = true;

    public EratoStation(int i) {
        this.number = i;
    }

    public synchronized void run() {
        while (running){
            if (buffer.size() != 0){
                int number = buffer.get(0);
                System.out.println("Thread "+this.number+" is working on "+number);;
                buffer.remove(0);
                if (number % this.number != 0) {
                    if (nextStation != null) {
                        try {
                            nextStation.pushBuffer(number);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        nextStation = new EratoStation(number);
                        nextStation.start();
                    }
                }
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void pushBuffer(int number) throws InterruptedException {
        buffer.add(number);
    }

    public void interrupt() {
        printThisStation();
        while (buffer.size() != 0){
            try{
                Thread.sleep(1);
            } catch (Exception e){
            }
        }
        this.running = false;
          
        if (nextStation != null) {
            nextStation.interrupt();
        }
    }

    public void printThisStation(){
        System.out.println(number);
    }
}
