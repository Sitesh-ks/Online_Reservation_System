import java.util.Scanner;

public class book {
	public int SNo;
	public String bookName;
	public String AuthorName;
	public int BQuantity;
	public int BQuantityCopy;
	String recommendedbooks;
	String recommendedAuthors;
	Scanner sc = new Scanner(System.in);

	public book() {
		System.out.println("Enter Book Serial Number : ");
		this.SNo = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Book Name : ");
		this.bookName = sc.nextLine();
		System.out.println("Enter Book's Author Name : ");
		this.AuthorName = sc.nextLine();
		System.out.println("Enter Quantity of Books : ");
		this.BQuantity = sc.nextInt();
		BQuantityCopy = this.BQuantity;
	}
}
