package second;

/**
 * Created by pietrocenciarelli on 14/03/21.
 */
public class TestPackagePrivate {
    public static void main(String[] args) {
        //shows the difference between private and package-private

        Powers p = new Powers();

        System.out.println(p.ninth); // access to a public field
        // System.out.println(p.tenth); // acces to a private field (failed!)
        System.out.println(p.eleventh); //Ok, because it's in the same packge, even though not a subclass
        System.out.println(p.twelfth); // access to a protected field
        // protectd seems to behave like public, but...
    }
}
