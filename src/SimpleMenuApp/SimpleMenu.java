package SimpleMenuApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleMenu {

    private ArrayList<Student> studentlist = new ArrayList<>();
    protected void DisplayMenu()
    {
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (InterruptedException | IOException e){
            System.out.println("Nu se poate curata consola: " + e.getMessage());
        }
        System.out.println("**** Gestionare Studenti ****\n");
        System.out.println("0. Iesire");
        System.out.println("1. Adaugare");
        System.out.println("2. Modificare");
        System.out.println("3. Stergere");
        System.out.println("4. Vizualizare");
        System.out.println("\n\nIntroduceti optiunea dvs. :");
    }

    public void Run()
    {
        int option = 0;
        Scanner consoleScanner = new Scanner(System.in);
        do
        {
            DisplayMenu();
            option = Integer.parseInt(consoleScanner.nextLine());
            switch (option)
            {
                case 1:
                    uiAddStudent(consoleScanner);
                    break;
                case 2:
                    uiModifyStudent(consoleScanner);
                    break;
                case 3:
                    uiDeleteStudent(consoleScanner);
                    break;
                case 4:
                    uiViewStudents();
                    break;
                default:
                    System.out.println("\nAlegeti o optiune valida :\n");
            }

        }while (option != 0);

        System.out.println("Aplicatia se va inchide.");
    }

    private void listStudent(Student student)
    {
        System.out.println(student.getId() + "\t" + student.getNume() + "\t" + student.getPrenume() + "\t" + student.getVarsta() );
    }

    private void uiViewStudents() {

        System.out.println("Id \tNume\tPrenume\t\tVarsta");

        for(Student currentStudent: studentlist)
        {
            listStudent(currentStudent);
        }
    }

    private void uiDeleteStudent(Scanner sc) {
        System.out.println("Introduceti ID-ul studentului pe care doriti sa il stergeti: ");
        int id = Integer.parseInt(sc.nextLine());
        studentlist.remove(new Student(id));
        System.out.println("\nStudentul a fost sters cu succes!");
    }

    private void uiModifyStudent(Scanner sc) {
        System.out.println("Introduceti ID-ul studentului pe care doriti sa il modificati: ");
        int id = Integer.parseInt(sc.nextLine());
        Student s = studentlist.get(studentlist.indexOf(new Student(id)));
        System.out.println("Introduceti noul nume: ");
        s.setNume(sc.nextLine());
        System.out.println("Introduceti noul prenume: ");
        s.setPrenume(sc.nextLine());
        System.out.println("Introduceti noua varsta: ");
        s.setVarsta(Integer.parseInt(sc.nextLine()));
        System.out.println("\nStudentul a fost modificat cu succes!");

    }

    private void uiAddStudent(Scanner sc) {
        System.out.println("Introduceti ID-ul studentului: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Introduceti numele studentului: ");
        String nume = sc.nextLine();
        System.out.println("Introduceti prenumele studentului: ");
        String prenume = sc.nextLine();
        System.out.println("Introduceti varsta studentului: ");
        int varsta = Integer.parseInt(sc.nextLine());
        Student student = new Student(id,nume, prenume, varsta);
        studentlist.add(student);

    }

}
