public class University {
    public String universityName;
    public int currentEnrolled;
    public int graduated;

    University(String name) {
        this.universityName = name;
    }
    
    public void printUni() {
        System.out.println(this.universityName);
        System.out.println("currently enrolled students: " + this.currentEnrolled);
        System.out.println(this.graduated + " students graduated as of today");
        System.out.println();
    }

    public void grantDegree(Student student, int year) throws GraduationException{
        int graduationYear = student.enrollmentYear + 3;
        if (graduationYear <= year){
            student.graduate();
        }
        else {
            throw new GraduationException(year, graduationYear, student);
        }
    }

    public class Course {
        public String courseName;
        public int currentEnrolledCourse;
        public int graduatedCourse;

        Course(String name) {
            this.courseName = name;
        }

        public void printCourse() {
            System.out.println(this.courseName + " course at " + University.this.universityName);
            System.out.println(this.currentEnrolledCourse + " students currently enrolled");
            System.out.println(this.graduatedCourse + " students graduated as of today");
            System.out.println();
        }

        public String printForStudent() {
            return "degree in " + this.courseName + " at " + University.this.universityName;
        }

        public void enrollStudent(){
            this.currentEnrolledCourse++;
            University.this.currentEnrolled++;
        }

        public void graduateStudent(){
            this.graduatedCourse++;
            University.this.graduated++;
            this.currentEnrolledCourse--;
            University.this.currentEnrolled--;
        }
    }
}
