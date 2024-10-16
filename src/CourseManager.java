import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Cours " + course.getName() + " ajouté.");
    }

    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("Aucun cours disponible.");
        } else {
            System.out.println("Cours disponibles :");
            for (Course course : courses) {
                System.out.println("- " + course.getName());
            }
        }
    }

    public Course getCourseByName(String courseName) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }
}
