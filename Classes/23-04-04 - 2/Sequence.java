/**
 * Created by pietrocenciarelli on 24/03/21.
 */

import java.util.*; // includes class Scanner

// see https://docs.oracle.com/javase/8/docs/api/java/util/List.html
// see https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html

public class Sequence {

    public static void main(String[] args) {
        // playing with generic class LinKedList

        LinkedList<String> text = new LinkedList<String>(); // a sequence of strings
        LinkedList<Integer> numbers = new LinkedList<Integer>(); // a sequence of integers

        Scanner input = new Scanner(System.in);

        // Class Scanner implements scanners of text, useful to input from keyboard
        // System.in is an object of type InputStream

        System.out.println("Please, type a word:");
        String s = input.nextLine(); // input of a string
        System.out.println("read " + s);

        System.out.println("Please, give me more words, separated by newline. Type finish at the end");

        int i = 1;
        while (!s.equals("finish")) { // input cycle
            text.add(s); // adds a string s to the text sequence
            numbers.add(new Integer(i++)); // adds a new integer to the sequence of integers
            s = input.nextLine(); // input of a new string
        }

        System.out.println("you wrote: ");
        i = 0;

        for (String x : text) // for-each cycle
            System.out.println(numbers.get(i++).intValue() + ": " + x);

    }
}
