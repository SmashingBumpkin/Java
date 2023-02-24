import java.util.Random;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        int x = 2;
        System.out.println(doIt(x,3));
        //histogram(40, 100);

        counter c1 = new counter();
        counter c2 = new counter();
        c1.tic();
        c1.tic();
        c2.tic();
        System.out.println(c1.get());
        System.out.println(c2.get());
        c1.universaltic();
        c1.universaltic();
        c1.universaltic();
        System.out.println(c2.getuni());
    }

    public static int doIt(int x, int y){
        if (y == 0){
            return x;
        }
        return doIt(x+1, y-1);
    }
    
    public static void histogram(int walkers, int steps){
        for (int i=0; i < walkers; i++){
            System.out.println(walker(steps));
        }
    }

    public static int walker(int steps){
        Random rand = new Random(); 
        int position = 0;
        for (int i = 0; i < steps; i++) {
            int int_random = rand.nextInt(2);
            if (int_random == 1){
                ++position;
            }
            else {
                --position;
            }
        }
        return position;
    }
}