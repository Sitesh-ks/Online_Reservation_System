import java.util.Scanner;

public class books {
	String recommendedbooks;
	String recommendedAuthors;
	book theBooks[] = new book[10000];
	public static int count;
	Scanner input = new Scanner(System.in);

	public int compareBookObjects(book b1, book b2) {
		if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
			System.out.println("Book of this Name Already Exists");
			return 0;
		}
		if (b1.SNo == b2.SNo) {
			System.out.println("Book of this Serial Number Already Exists");
			return 0;
		}
		return 1;
	}

	public void addBook(book b) {
		for (int i = 0; i < count; i++) {
			if (this.compareBookObjects(b, this.theBooks[i]) == 0)
				return;
		}
		if (count < 50) {
			theBooks[count] = b;
			count++;
		} else {
			System.out.println("There's no more space to add books");
		}
	}

	public void searchBySNo() {
		System.out.println();
		System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
		int SNo;
		System.out.println("Enter Serial Number of Book : ");
		SNo = input.nextInt();
		int flag = 0;
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for (int i = 0; i < count; i++) {
			if (SNo == theBooks[i].SNo) {
				System.out.println(theBooks[i].SNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].AuthorName
						+ "\t\t" + theBooks[i].BQuantityCopy + "\t\t" + theBooks[i].BQuantity);
				flag++;
				return;
			}
		}
		if (flag == 0)
			System.out.println("No Book for Serial Number " + SNo + " Found");
	}

	public void searchByAuthorName() {
		System.out.println();
		System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
		System.out.println("Enter Author Name : ");
		String AuthorName = input.nextLine();
		int flag = 0;
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for (int i = 0; i < count; i++) {
			if (AuthorName.equalsIgnoreCase(theBooks[i].AuthorName)) {
				System.out.println(theBooks[i].SNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].AuthorName
						+ "\t\t" + theBooks[i].BQuantityCopy + "\t\t" + theBooks[i].BQuantity);
				flag++;
			}
		}
		if (flag == 0)
			System.out.println("No Books of " + AuthorName + " Found");
	}

	public void showAllBooks() {
		System.out.println();
		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
		for (int i = 0; i < count; i++) {
			System.out.println(theBooks[i].SNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].AuthorName
					+ "\t\t" + theBooks[i].BQuantityCopy + "\t\t" + theBooks[i].BQuantity);
		}
	}

	public void upgradeBQuantity() {
		System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		System.out.println("Enter Serial Number of Book : ");
		int SNo = input.nextInt();
		for (int i = 0; i < count; i++) {
			if (SNo == theBooks[i].SNo) {
				// Display message
				System.out.println("Enter No of Books to be Added : ");
				int addingQty = input.nextInt();
				theBooks[i].BQuantity += addingQty;
				theBooks[i].BQuantityCopy += addingQty;
				return;
			}
		}
	}

	public void dispMenu() {
		System.out.println("Press the Corresponding Number for that Particular Action to be performed");
		System.out.println(
				"__________________________________________________________________________________________________________");
		System.out.println("0 - Exit Application.");
		System.out.println("1 - Add New Book.");
		System.out.println("2 - Upgrade Quantity of a Book.");
		System.out.println("3 - Search a Book.");
		System.out.println("4 - Show All Books.");
		System.out.println("5 - Register Student.");
		System.out.println("6 - Show All Registered Students.");
		System.out.println("7 - Check Out Book. ");
		System.out.println("8 - Check In Book");
		System.out.println(
				"__________________________________________________________________________________________________________");
	}

	public int isAvailable(int SNo) {
		for (int i = 0; i < count; i++) {
			if (SNo == theBooks[i].SNo) {
				if (theBooks[i].BQuantityCopy > 0) {
					System.out.println("Book is Available");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}
		System.out.println("No Book of Serial Number " + " Available in Library");
		return -1;
	}

	public book checkOutBook() {
		System.out.println("Enter Serial Number of Book to be Checked Out : ");
		int SNo = input.nextInt();
		int bookIndex = isAvailable(SNo);
		if (bookIndex != -1) {
			theBooks[bookIndex].BQuantityCopy--;
			return theBooks[bookIndex];
		}
		return null;
	}

	public void checkInBook(book b) {
		for (int i = 0; i < count; i++) {
			if (b.equals(theBooks[i])) {
				theBooks[i].BQuantityCopy++;
				return;
			}
		}
	}
}