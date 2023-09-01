import java.util.Scanner;

public class student {
    String studentName;
    String recommendedbooks;
    String recommendedAuthors;
    String regNum;
    book borrowedBooks[] = new book[3];
    public int booksCount = 0;
    Scanner sc = new Scanner(System.in);

    public student() {
        System.out.println("Enter Student Name : ");
        this.studentName = sc.nextLine();
        System.out.println("Enter Registration Number : ");
        this.regNum = sc.nextLine();
    }
}
