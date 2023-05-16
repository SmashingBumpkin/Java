/**
 * Created by pietrocenciarelli on 06/05/23.
 * 
 * Provide a concurrent implementation of Eratosthenes' sieve. Prime numbers are found by dynamically constructing a linked list of threads,
 * each one representing a specific prime number and pointing to a thread representing the next prime. We denote by [p] the thread representing
 * prime p. A chain of length 4, for example, will consist of a linked list of threads representing, in the order, the first 4 primes: 
 * [2] -> [3] -> [5] -> [7]. 
 * 
 * The next prime is computed by the chain as follows: numbers n greater than 7 are orderly fed to the chain, starting from [2], and are passed 
 * across the chain according to the following protocol: each thread [p] in the chain receives a number n from the preceding thread; if p 
 * divides n, then n is dropped because not a prime, otherwise it is passed by [p] on to the next thread for further divisibility checks. Thus, 
 * n travels left to right through the chain till either it is found to be divisible by some prime, and hence not passed any further, or it 
 * reaches the end of the chain, in which case it must be a prime because not divisible by any of the smaller primes. In that case a new thread 
 * [n] is added at the bottom of the chain. Threads may follow this protocol in parallel. When 8 is fed to the above chain, it is immediately 
 * intercepted by thread [2] and dropped. Next, 9 is presented to [2] and, not being divisible by 2, is passed on to thread [3]. Now, while [3] 
 * checks if 9 can be divided by 3 (and dropped consequently), [2] can concurrently work the next number, 10. Of course this requires careful 
 * synchronization on the buffers used to pass numbers along.
 * 
 *  Implement the above concurrent algorithm to print the first 100 primes: 2 3 5 ... 97. Implementation should provide a class EratoStation 
 * working in conjunction with the main provided below.
 * 
 * 
 * Optional (nothing to hand in!!): provide a sequential implementation of Eratosthenes' sieve and check if it runs faster than the concurrent.
 */
public class Eratosthenes {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // EratoStation chain = new EratoStation(2);
        // EratoStation2 chain = new EratoStation2(2);
        EratoStation4 chain = new EratoStation4(2);
        chain.start();

        try {
            for (int number = 3; number < 100; number++){
                System.out.println("Number: " + number);
                chain.pushBuffer(number);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Shouldn't happen!");
        }
        chain.interrupt();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("The code took " + duration + " milliseconds to execute");
    }
}
