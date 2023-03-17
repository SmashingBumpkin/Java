package second;

/**
 * Created by pietrocenciarelli on 07/03/21.
 */
public class Powers {

    // access modifiers

    public int ninth = 512; //available anywhere
    private int tenth = 1024;//Not available to ANY other class (legally)
    protected int eleventh = 2048; //Available to subclasses, and package not outside
    int twelfth = 4096; //"package-private"
}
