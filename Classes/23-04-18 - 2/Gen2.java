/**
 * Created by pietrocenciarelli on 31/03/21.
 */

public class Gen2 <E> extends Gen1<E> {

    E something = null;

    Integer m(E x) {
        return 88;
    }

    public static void main(String[] args) {
        // testing generic subtypes

        Gen1<Object> x = new Gen1<Object>();
        x = new Gen2<Object>(); // Gen2<Object> is a subtype of Gen1<Object>
        // x = new Gen1<String>(); // Gen1<String> is *not* a subtype of Gen1<Object>.
        // Explain why: co- & contra- variance
    }
}
