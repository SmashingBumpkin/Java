/**
 * Created by pietrocenciarelli on 09/05/21.
 */


@MyClassAnnotation(
        author = "pietrocenciarelli",
        versionNumber = 1,
        date = "09/05/2021")

public class TestAnnotations extends SuperClass {

    @MyMethodAnnotation(
            state = MethodStates.APPROVED
    )
    public void m () {
        uglyMethod();
    }

    @Override
    void superMethod () {
    }

    public static void main(String[] args) {
        new TestAnnotations().m();
    }
}
