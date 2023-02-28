import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class HelloWorld {
    public static void main(String[] args) {
        Map <Integer, Integer> my_histogram = histogram(2000, 500);
        Set<Integer> orderedKeys = new TreeSet<>(my_histogram.keySet());
        System.out.println(my_histogram);
        for (int walker : orderedKeys) {
            int occurences = my_histogram.get(walker);
            String stars = "";
            for (int i=0; i<occurences; i++) {
                stars += "*";
            }
            //System.out.println(walker + ": " + stars);
            System.out.printf("\n%i %s ",  walker, stars);
          }
    }

    public static Map<Integer,Integer> histogram(int walkers, int steps){
        int[] results = new int[walkers];
        for (int i=0; i < walkers; i++){
            results[i] = walker(steps);
        }
        Map<Integer, Integer> histDic = new HashMap<>();
        for (int result : results) {
            histDic.put(result, histDic.getOrDefault(result, 0) + 1);
        }
        return histDic;
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

    public static int doIt(int x, int y){
        if (y == 0){
            return x;
        }
        return doIt(x+1, y-1);
    }
    
}