
import java.util.ArrayList;
import java.util.List;

class RegistrationSystem {
    private List<Course> courseDatabase;
    private List<Student> studentDatabase;

    public RegistrationSystem() {
        this.courseDatabase = new ArrayList<>();
        this.studentDatabase = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courseDatabase.add(course);
    }

    public void addStudent(Student student) {
        studentDatabase.add(student);
    }

    public void displayCourseListing() {
        System.out.println("\nCourse Listing:");
        for (Course course : courseDatabase) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + (course.getCapacity() - getRegisteredCount(course)));
            System.out.println("------------------------------");
        }
    }

    private int getRegisteredCount(Course course) {
        int count = 0;
        for (Student student : studentDatabase) {
            if (student.getRegisteredCourses().contains(course)) {
                count++;
            }
        }
        return count;
    }

    public void displayStudentRegistration(int studentID) {
        for (Student student : studentDatabase) {
            if (student.getStudentID() == studentID) {
                System.out.println("\nStudent Registration for " + student.getName() + ":");
                for (Course course : student.getRegisteredCourses()) {
                    System.out.println(course.getCourseCode() + " - " + course.getTitle());
                }
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentID);
    }

    public void studentRegistration(int studentID, String courseCode) {
        Student student = findStudent(studentID);
        Course course = findCourse(courseCode);

        if (student != null && course != null) {
            if (getRegisteredCount(course) < course.getCapacity()) {
                student.registerCourse(course);
                System.out.println("Registration successful for " + student.getName() + " in " + course.getTitle());
            } else {
                System.out.println("Course " + course.getTitle() + " is full. Registration failed.");
            }
        } else {
            System.out.println("Student or Course not found. Registration failed.");
        }
    }

    public void studentCourseRemoval(int studentID, String courseCode) {
        Student student = findStudent(studentID);
        Course course = findCourse(courseCode);

        if (student != null && course != null) {
            student.dropCourse(course);
            System.out.println("Course removal successful for " + student.getName() + " from " + course.getTitle());
        } else {
            System.out.println("Student or Course not found. Course removal failed.");
        }
    }

    private Student findStudent(int studentID) {
        for (Student student : studentDatabase) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private Course findCourse(String courseCode) {
        for (Course course : courseDatabase) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
