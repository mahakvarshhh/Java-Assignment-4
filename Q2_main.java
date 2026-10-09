import java.util.HashSet;
import java.util.Scanner;

class Attendance {
    HashSet<String> students = new HashSet<>();

    void markAttendance(String name) {
        if (students.add(name)) {
            System.out.println("Attendance marked for " + name);
        } else {
            System.out.println(name + " is already marked present");
        }
    }

    void displayAttendance() {
        System.out.println("Present Students: " + students);
    }
}

public class Q2_main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attendance attendance = new Attendance();
        String choice;

        do {
            System.out.print("Enter name to mark attendance: ");
            attendance.markAttendance(sc.nextLine());

            System.out.print("Mark another student? (yes/no): ");
            choice = sc.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        attendance.displayAttendance();
        sc.close();
    }
}

