import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Plateforme de gestion de cours en ligne ===");
            System.out.println("1. Ajouter un cours");
            System.out.println("2. Afficher les cours disponibles");
            System.out.println("3. Inscrire un étudiant");
            System.out.println("4. Afficher les étudiants inscrits à un cours");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option: ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom du cours: ");
                    String courseName = scanner.nextLine();
                    courseManager.addCourse(new Course(courseName));
                    break;
                case 2:
                    courseManager.displayCourses();
                    break;
                case 3:
                    System.out.print("Entrez le nom de l'étudiant: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Entrez le nom du cours: ");
                    String courseToEnroll = scanner.nextLine();
                    studentManager.enrollStudent(studentName, courseToEnroll, courseManager);
                    break;
                case 4:
                    System.out.print("Entrez le nom du cours: ");
                    String courseToDisplay = scanner.nextLine();
                    studentManager.displayStudents(courseToDisplay);
                    break;
                case 5:
                    running = false;
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }
}
