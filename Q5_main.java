import java.util.LinkedHashSet;
import java.util.Scanner;

class CourseEnrollment {
    LinkedHashSet<String> students = new LinkedHashSet<>();

    void enrollStudent(String name) {
        if (students.add(name)) {
            System.out.println("Enrolled: " + name);
        } else {
            System.out.println(name + " is already enrolled");
        }
    }

    void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }
}

public class Q5_main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseEnrollment course = new CourseEnrollment();
        String choice;

        do {
            System.out.print("Enroll: ");
            course.enrollStudent(sc.nextLine());

            System.out.print("Enroll another student? (yes/no): ");
            choice = sc.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        course.displayEnrolledStudents();
        sc.close();
    }
}
