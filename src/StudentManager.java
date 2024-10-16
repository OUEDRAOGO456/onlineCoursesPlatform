import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {
    private Map<String, List<Student>> courseEnrollments;

    public StudentManager() {
        courseEnrollments = new HashMap<>();
    }

    public void enrollStudent(String studentName, String courseName, CourseManager courseManager) {
        Course course = courseManager.getCourseByName(courseName);
        if (course != null) {
            Student student = new Student(studentName);
            courseEnrollments.putIfAbsent(course.getName(), new ArrayList<>());
            courseEnrollments.get(course.getName()).add(student);
            System.out.println("Étudiant " + studentName + " inscrit au cours " + courseName + ".");
        } else {
            System.out.println("Cours non trouvé.");
        }
    }

    public void displayStudents(String courseName) {
        List<Student> students = courseEnrollments.get(courseName);
        if (students == null || students.isEmpty()) {
            System.out.println("Aucun étudiant inscrit à ce cours.");
        } else {
            System.out.println("Étudiants inscrits au cours " + courseName + " :");
            for (Student student : students) {
                System.out.println("- " + student.getName());
            }
        }
    }
}
