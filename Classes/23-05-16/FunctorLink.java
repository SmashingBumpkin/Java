import java.util.function.Function;

/**
 * Created by pietrocenciarelli on 10/05/21.
 */

public class FunctorLink <T> implements Functor <T> {

    // linked lists are functors

    public T val;
    public FunctorLink<T> next;

    public FunctorLink (T val, FunctorLink<T> next) {
        this.val = val;
        this.next = next;
    }

    @FunctorCorrectness(condition = "fmap(f).fmap(g) = fmap(f.andThen(g))")

    public <R> FunctorLink<R> fmap (Function<T, R> f) {
        return new FunctorLink<R>(f.apply(val), (next == null) ? null :next.fmap(f));
        // return new FunctorLink<R> (f.apply(val), next.fmap(f));
    }
}
