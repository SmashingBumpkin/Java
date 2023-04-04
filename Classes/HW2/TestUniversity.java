/**
 * Created by pietrocenciarelli on 04/04/22.
 */
public class TestUniversity {

    public static void main(String[] args) {

        University cambridge = new University("University of Cambridge");
        cambridge.printUni();

        University sapienza = new University("Sapienza University");
        sapienza.printUni();

        University.Course cs_cambridge = cambridge.new Course("Computer Science");
        University.Course bio_cambridge = cambridge.new Course("Biology");
        University.Course bio_sapienza = sapienza.new Course("Biology");

        Student s1 = new Student(cs_cambridge, 2017);
        Student s2 = new Student(cs_cambridge, 2018);
        Student s3 = new Student(cs_cambridge, 2019);
        Student s4 = new Student(cs_cambridge, 2020);
        Student s5 = new Student(bio_cambridge, 2018);
        Student s6 = new Student(bio_sapienza, 2018);
        Student s7 = new Student(bio_sapienza, 2022);

        cambridge.printUni();
        sapienza.printUni();
        cs_cambridge.printCourse();
        s1.printStudent();

        try {
            cambridge.grantDegree(s1, 2022);
            cambridge.grantDegree(s4, 2022);
        }
        catch (GraduationException e) {
            System.out.println(e.getMessage());
        }

        cambridge.printUni();
        cs_cambridge.printCourse();
        bio_cambridge.printCourse();
        sapienza.printUni();
    }
    /*
    The following output is expected:

University of Cambridge
currently enrolled students: 0
0 students graduated as of today

Sapienza University
currently enrolled students: 0
0 students graduated as of today

University of Cambridge
currently enrolled students: 5
0 students graduated as of today

Sapienza University
currently enrolled students: 2
0 students graduated as of today

Computer Science course at University of Cambridge
4 students currently enrolled
0 students graduated as of today

Student matriculation number = 1
degree in Computer Science at University of Cambridge
year of registration: 2017

Student 1 is granted a degree in Computer Science at University of Cambridge, CONGRATULATIONS!

2022: Student 4 is only allowed to graduate from 2023

University of Cambridge
currently enrolled students: 4
1 students graduated as of today

Computer Science course at University of Cambridge
3 students currently enrolled
1 students graduated as of today

Biology course at University of Cambridge
1 students currently enrolled
0 students graduated as of today

Sapienza University
currently enrolled students: 2
0 students graduated as of today
     */
}
