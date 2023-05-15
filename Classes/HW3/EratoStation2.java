public class EratoStation2 {
    private final int number;
    private EratoStation2 nextStation = null;

    public EratoStation2(int i) {
        this.number = i;
    }

    public void run() {
    }

    public void start() {
    }

    public void pushBuffer(int number) throws InterruptedException {
        System.out.println("Thread " + this.number + " is currently working on " + number);
        if (number % this.number != 0) {
            if (nextStation != null) {
                nextStation.pushBuffer(number);
            } else {
                nextStation = new EratoStation2(number);
            }
        }
    }

    public void interrupt() {
    }

    public void printThisStation() {
        System.out.println(number);
    }
}
