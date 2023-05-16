/**
 * Created by pietrocenciarelli on 10/05/21.
 */

import java.util.function.Function;

public class TestFunction {

    public static void main(String[] args) {
        /*
        Generic interface Function <T,R> represents functions T -> R
        (input vales in T, results in R). It is a functional interface
        with an abstract method apply: R -> T and two default generic
        methods: compose and andThen.
        Two functions are defined here, succ (successor) and twice
        (times two), and composed in various ways.
         */

        // Integer eight = new Integer(8);
        Integer eight = 8;

        Function <Integer, Integer> succ = (x) -> x+1; // successor
        System.out.println(succ.apply(eight));

        Function <Integer, Integer> twice = (x) -> x+x; // times two
        Function <Integer, Integer> succtwice = succ.compose(twice);
        /*
        f.compose(g) pre-composition, returns f.g, dove g: A -> B e f: B -> C
        */
        System.out.println(succtwice.apply(eight));

        Function succtwice2 = succ.compose(twice); // type inference
        System.out.println(succtwice2.apply(eight));

        Function <Integer, Integer> twicesucc = succ.andThen(twice);
        /*
        f.andThen(g) restituisce la funzione composta g.f, dove f: A -> B e g: B -> C
        */
        System.out.println(twicesucc.apply(eight));

        // Function also features a generic static method identity

        System.out.println(Function.<Integer>identity().apply(eight)); // identity on Integer
        System.out.println(Function.identity().apply(eight)); // type inference!
        System.out.println((Function.identity()).apply("ciao")); // identity on String
    }
}
