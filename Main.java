
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();

        // Adding Courses to the System
        registrationSystem.addCourse(new Course("CS", "Introduction to Computer Science", "Fundamentals of programming", 50, "Mon, Wed, Fri"));
        registrationSystem.addCourse(new Course("MATH", "Calculus I", "Limits, derivatives, and integrals", 40, "Tue, Thu"));
        registrationSystem.addCourse(new Course("ENG", "English Composition", "Writing and communication skills", 30, "Mon, Wed"));

        // Adding Students to the System
        registrationSystem.addStudent(new Student(1, "Kajal Jadhav"));
        registrationSystem.addStudent(new Student(2, "Rutuja Shinde"));
        registrationSystem.addStudent(new Student(3, "Prajkta Gunaware"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Course Registration System Menu:");
            System.out.println("1. Display Course Listing");
            System.out.println("2. Display Student Registration");
            System.out.println("3. Student Registration");
            System.out.println("4. Student Course Removal");
//            System.out.println("5. Display list of Registered Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registrationSystem.displayCourseListing();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    registrationSystem.displayStudentRegistration(studentID);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int regStudentID = scanner.nextInt();
                    System.out.print("Enter course code: ");
                    String regCourseCode = scanner.next();
                    registrationSystem.studentRegistration(regStudentID, regCourseCode);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int remStudentID = scanner.nextInt();
                    System.out.print("Enter course code: ");
                    String remCourseCode = scanner.next();
                    registrationSystem.studentCourseRemoval(remStudentID, remCourseCode);
                    break;
//                case 5:
//                	System.out.println("Number of students: ");
//                	registrationSystem.getRegisteredCount();
                case 5:
                    System.out.println("Exiting. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
