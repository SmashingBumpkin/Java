public class Student {
    private static int globalStudentNumber = 0;
    public int studentNumber;
    public University.Course course;
    public int enrollmentYear;

    Student(University.Course course, int year){
        this.studentNumber = ++globalStudentNumber;
        this.course = course;
        this.enrollmentYear = year;
        this.course.enrollStudent();
    }

    public void graduate(){
        System.out.println("Student "+ studentNumber +" is granted a " + this.course.printForStudent() + ", CONGRATULATIONS!\n");
        this.course.graduateStudent();
    }

    public void printStudent(){
        System.out.print("Student matriculation number = ");
        System.out.println(this.studentNumber);
        System.out.println(this.course.printForStudent());
        System.out.print("year of registration: ");
        System.out.println(this.enrollmentYear);
        System.out.println();
    }
}
