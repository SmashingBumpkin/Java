public class OutOfBoundsException extends Exception {
    public int index;
    public int size;
    public OutOfBoundsException(int size,int index){
        this.size = size;
        this.index = index;
    }
    public void printException(){
        System.out.println("OutOfBoundsException: Index: "+index+", Size: " + size);
    }
}
