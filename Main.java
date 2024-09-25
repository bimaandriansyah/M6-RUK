import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Tambah Data Guru");
                System.out.println("2. Tambah Data Siswa");
                System.out.println("3. Tambah Data Mata Pelajaran");
                System.out.println("4. Tampilkan Semua Data");
                System.out.println("5. Keluar");
                System.out.print("Pilih opsi: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("\n=== Tambah Data Guru ===");
                        while (true) {
                            System.out.print("Masukkan nama guru: ");
                            String teacherName = scanner.nextLine();
                            int teacherAge = inputValidAge(scanner);
                            System.out.print("Masukkan mata pelajaran yang diajarkan: ");
                            String teacherSubject = scanner.nextLine();

                            teachers.add(new Teacher(teacherName, teacherAge, teacherSubject));

                            System.out.print("Tambah guru lagi? (y/n): ");
                            if (scanner.nextLine().equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                        break;

                    case 2:
                        System.out.println("\n=== Tambah Data Siswa ===");
                        while (true) {
                            System.out.print("Masukkan nama siswa: ");
                            String studentName = scanner.nextLine();
                            int studentAge = inputValidAge(scanner);
                            System.out.print("Masukkan jurusan siswa: ");
                            String studentMajor = scanner.nextLine();

                            students.add(new Student(studentName, studentAge, studentMajor));

                            System.out.print("Tambah siswa lagi? (y/n): ");
                            if (scanner.nextLine().equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n=== Tambah Data Mata Pelajaran ===");
                        while (true) {
                            System.out.print("Masukkan nama mata pelajaran: ");
                            String courseName = scanner.nextLine();

                            if (teachers.isEmpty()) {
                                System.out.println("Tidak ada guru yang tersedia. Tambah guru terlebih dahulu.");
                                break;
                            }

                            System.out.println("Pilih guru yang mengajar: ");
                            for (int i = 0; i < teachers.size(); i++) {
                                System.out.println((i + 1) + ". " + teachers.get(i).name);
                            }
                            
                            int teacherIndex = inputValidTeacherIndex(scanner, teachers.size());

                            courses.add(new Course(courseName, teachers.get(teacherIndex - 1)));

                            System.out.print("Tambah mata pelajaran lagi? (y/n): ");
                            if (scanner.nextLine().equalsIgnoreCase("n")) {
                                break;
                            }
                        }
                        break;

                    case 4:
                        System.out.println("\n=== Data Guru ===");
                        for (Teacher teacher : teachers) {
                            teacher.displayInfo();
                            System.out.println();
                        }

                        System.out.println("\n=== Data Siswa ===");
                        for (Student student : students) {
                            student.displayInfo();
                            System.out.println();
                        }

                        System.out.println("\n=== Data Mata Pelajaran ===");
                        for (Course course : courses) {
                            course.displayCourseInfo();
                            System.out.println();
                        }
                        break;

                    case 5:
                        System.out.println("Keluar dari program...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka untuk pilihan menu.");
                scanner.nextLine(); 
            }
        }
    }

    private static int inputValidAge(Scanner scanner) {
        int age = -1;
        while (age < 0) {
            try {
                System.out.print("Masukkan umur: ");
                age = scanner.nextInt();
                scanner.nextLine(); 
                if (age < 0) {
                    System.out.println("Umur tidak boleh negatif. Coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine();
            }
        }
        return age;
    }

    private static int inputValidTeacherIndex(Scanner scanner, int maxIndex) {
        int index = -1;
        while (index < 1 || index > maxIndex) {
            try {
                System.out.print("Masukkan nomor guru: ");
                index = scanner.nextInt();
                scanner.nextLine(); 
                if (index < 1 || index > maxIndex) {
                    System.out.println("Nomor guru tidak valid. Pilih nomor yang ada di daftar.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine();
            }
        }
        return index;
    }
}