import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Course Code: " + code + "\nTitle: " + title + "\nDescription: " + description + "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}

class Student {
    private int id;
    private String name;
    private List<String> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }
}

public class Task5 {
    private Map<String, Course> courses = new HashMap<>();
    private Map<Integer, Student> students = new HashMap<>();
    private int nextStudentId = 1;

    public void addCourse(String code, String title, String description, int capacity, String schedule) {
        Course course = new Course(code, title, description, capacity, schedule);
        courses.put(code, course);
        System.out.println("Course added successfully.");
    }

    public void displayCourseListing() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Available Courses:");
            for (Course course : courses.values()) {
                System.out.println(course);
                System.out.println();
            }
        }
    }

    public void registerStudent(String name) {
        Student student = new Student(nextStudentId++, name);
        students.put(student.getId(), student);
        System.out.println("Student registered successfully.");
    }

    public void displayStudentRegistration() {
        System.out.println("Student Registration Details:");
        for (Student student : students.values()) {
            System.out.println("Student ID: " + student.getId() + "\nName: " + student.getName());
            List<String> registeredCourses = student.getRegisteredCourses();
            if (registeredCourses.isEmpty()) {
                System.out.println("No registered courses.");
            } else {
                System.out.println("Registered Courses:");
                for (String courseCode : registeredCourses) {
                    Course course = courses.get(courseCode);
                    System.out.println(course.getTitle() + " (Code: " + course.getCode() + ")");
                }
            }
            System.out.println();
        }
    }

    public void registerStudentForCourse(int studentId, String courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student != null && course != null) {
            if (student.getRegisteredCourses().size() < 3) {
                student.getRegisteredCourses().add(courseCode);
                System.out.println("Student registered for the course: " + course.getTitle());
            } else {
                System.out.println("You've already registered for 3 courses. Drop a course to register for a new one.");
            }
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void dropCourse(int studentId, String courseCode) {
        Student student = students.get(studentId);
        if (student != null) {
            if (student.getRegisteredCourses().remove(courseCode)) {
                System.out.println("Course " + courseCode + " dropped successfully.");
            } else {
                System.out.println("You are not registered for this course.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRegistrationSystem registrationSystem = new StudentRegistrationSystem();

        while (true) {
            System.out.println();
            System.out.println("Student Registration System");
            System.out.println("1. Add Course");
            System.out.println("2. Display Course Listing");
            System.out.println("3. Register Student");
            System.out.println("4. Display Student Registration");
            System.out.println("5. Register Student for a Course");
            System.out.println("6. Drop a Course");
            System.out.println("7. Exit");
	    System.out.println();
            System.out.print("Select an option: ");
	    System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
	    System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter Course Code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter Course Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Course Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Course Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Course Schedule: ");
                    String schedule = scanner.nextLine();

                    registrationSystem.addCourse(code, title, description, capacity, schedule);
                    break;
                case 2:
                    registrationSystem.displayCourseListing();
                    break;
                case 3:
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    registrationSystem.registerStudent(studentName);
                    break;
                case 4:
                    registrationSystem.displayStudentRegistration();
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();
                    registrationSystem.registerStudentForCourse(studentId, courseCode);
                    break;
                case 6:
                    System.out.print("Enter Student ID: ");
                    int studentIdDrop = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Course Code: ");
                    String courseCodeDrop = scanner.nextLine();
                    registrationSystem.dropCourse(studentIdDrop, courseCodeDrop);
                    break;
                case 7:
                    System.out.println("Thank You! Visit again, Hope you had a great experience!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
