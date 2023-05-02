public class BadBoys {
    public static void main(String[] args) throws InterruptedException {
        JimKongUn K = new JimKongUn();
        Thread D = new Thread(new RonaldDrump());
        EnricoBossi governatore = new EnricoBossi();
        // Thread G = new Thread(governatore);

        K.start();
        D.start();
        // G.start();

        // Thread.sleep(1);

        K.interrupt();
        D.interrupt();
        //G.interrupt();
        governatore.fermati();
    }
}