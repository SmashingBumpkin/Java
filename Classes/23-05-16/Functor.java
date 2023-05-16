import java.util.function.Function;

/**
 * Created by pietrocenciarelli on 10/05/21.
 */
public interface Functor <T> {
            /*
    A functor maps (method fmap) morphisms f:A -> B to morphisms
    Functor(f): Functor(A) -> Functor(B). One would then expect
    the following signature:

    <R> Function<Functor<T>, Functor<R>> fmap (Function <T, R> f);

     However fmap is a metod of an instance F of class Functor <T>;
     hence, given f of type Function <T, R>, F.fmap(f) returns
     a result of type Functor<R>
     */

    @FunctorCorrectness(condition = "fmap(f).fmap(g) = fmap(f.andThen(g))")
    <R> Functor<R> fmap (Function <T, R> f);
}