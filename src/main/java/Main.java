import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentRepository service = context.getBean(StudentRepository.class);

        Scanner scanner = new Scanner(System.in);

        int ch = 1;
        while(true){

            System.out.println("*************************MENU************************");
            System.out.println("1. Display the entire list of students");
            System.out.println("2. Remove student by ID");
            System.out.println("3. Add student to DB");
            System.out.println("4. Withdraw student ID");
            System.out.println("0. EXIT");
            System.out.println("*****************************************************");

            List<Student> all = service.findAll();
            switch (scanner.nextInt()){
                case 1:
                    all.forEach(item -> System.out.println(item));
                    System.out.println("___________________________________________________");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Enter student ID: ");
                    long id = scanner.nextLong();
                    service.delete(id);
                    System.out.println("the student has been deleted. To check choose menu item 1: ");
                    System.out.println("___________________________________________________");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Enter student ID: ");
                    long id1 = scanner.nextLong();
                    System.out.println("Enter student name:");
                    String name = scanner.next();
                    System.out.println("Enter student age:");
                    int age = scanner.nextInt();
                    System.out.println("Enter student group:");
                    int group = scanner.nextInt();
                    System.out.println("Enter student averge score:");
                    double averge_mark = scanner.nextDouble();
                    service.add(id1, name, age, group, averge_mark);
                    System.out.println("student has been added. To check, select menu item 1");
                    System.out.println("___________________________________________________");
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Enter student ID");
                    long id2 = scanner.nextLong();
                    System.out.println("student by selected ID: " + service.findById(id2));
                    System.out.println("___________________________________________________");
                    System.out.println("");
                    break;
                case 0:
                    ch =0;
                    break;
            }
            if(ch == 0) break;
        }

    }
}
