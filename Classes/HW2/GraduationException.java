public class GraduationException extends Exception {
    public int currentYear;
    public int graduationYear;
    public int studentNumber;

    public GraduationException(int currentYear, int graduationYear, Student student){
        this.currentYear = currentYear;
        this.graduationYear = graduationYear;
        this.studentNumber = student.studentNumber;
    }
    
    public String getMessage(){
        String  output = currentYear + ": Student "+ this.studentNumber + " is only allowed to graduate from " + graduationYear + "\n";
        return output;
    }
}