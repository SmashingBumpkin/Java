public class counter {
    public int mystery = 0;
    public static int hellojeff = 0;

    public void tic () {
        System.out.println("tic ");
        mystery++;
    }

    public int get () { return mystery; }

    public void universaltic () {
        System.out.println("unitic ");
        hellojeff++;
    }

    public int getuni () { return hellojeff; }
}
