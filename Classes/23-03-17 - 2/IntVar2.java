/**
 * Created by pietrocenciarelli on 14/03/21.
 */
public class IntVar2 implements IntVar {

    // implements int(-eger) variables... weirdly!

    private int val = 0;

    public int get () {
        return -val;
    }

    public void assign (int val) {
        this.val = -val;
    }
}
