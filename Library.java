import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "__________________________________________________________________________________________________________");
        System.out.println(
                "_____________________________________DIGITAL LIBRARY MANAGEMENT___________________________________________");
        System.out.println();
        System.out.println(
                "	                             Select From The Following Options	                                 	  ");
        System.out.println(
                "__________________________________________________________________________________________________________");
        books ob = new books();
        students obStudent = new students();
        int choice;
        int searchChoice;
        String recommendedbooks;
        String recommendedAuthors;
        do {
            ob.dispMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    book b = new book();
                    ob.addBook(b);
                    break;
                case 2:
                    ob.upgradeBQuantity();
                    break;
                case 3:
                    System.out.println(" Press 1 to Search with Book Serial Number");
                    System.out.println(" Press 2 to Search with Book's Author Name");
                    searchChoice = sc.nextInt();
                    switch (searchChoice) {
                        case 1:
                            ob.searchBySNo();
                            break;
                        case 2:
                            ob.searchByAuthorName();
                            break;
                    }
                case 4:
                    ob.showAllBooks();
                    break;
                case 5:
                    student s = new student();
                    obStudent.addStudent(s);
                    break;
                case 6:
                    obStudent.showAllStudents();
                    break;
                case 7:
                    obStudent.checkOutBook(ob);
                    break;
                case 8:
                    obStudent.checkInBook(ob);
                    break;
                default:
                    System.out.println("EXIT");
            }
        } while (choice != 0);
    }
}