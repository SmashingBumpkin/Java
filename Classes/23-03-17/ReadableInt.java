/**
 * Created by pietrocenciarelli on 14/03/21.
 */
public interface ReadableInt {

    static final int value = 42;

    static void blorg (int v) {
        System.out.println(value + v);
    }

    int get ();
}
