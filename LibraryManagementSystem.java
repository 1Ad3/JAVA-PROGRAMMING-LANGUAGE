import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    String title;
    String author;
    boolean isIssued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

// Library Class
class Library {
    ArrayList<Book> books = new ArrayList<>();

    // Add New Book
    void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Book added successfully.");
    }

    // Issue a Book
    void issueBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    // Return a Book
    void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid book or book not issued.");
    }

    // View Available Books
    void viewAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.isIssued) {
                System.out.println("- " + book.title + " by " + book.author);
            }
        }
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        System.out.println("Welcome to Library Management System");

        while (true) {
            System.out.println("\n1. Add New Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter title of the book to issue: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueTitle);
                    break;

                case 3:
                    System.out.print("Enter title of the book to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case 4:
                    library.viewAvailableBooks();
                    break;

                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
