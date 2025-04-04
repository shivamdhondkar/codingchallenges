import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int ISBN;

    
    public Book(String t, String a, int i) {
        this.title = t;
        this.author = a;
        this.ISBN = i;
    }

    public Book(String t, String a) {
        this.title = t;
        this.author = a;
        this.ISBN = 0; 
    }

    public Book(String t, int i) {
        this.title = t;
        this.author = "Unknown"; 
        this.ISBN = i;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book newBook) {
        books.add(newBook);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author + ", ISBN: " + book.ISBN);
        }
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    int ISBN = scanner.nextInt();
                    myLibrary.addBook(new Book(title, author, ISBN));
                    System.out.println("Book added successfully!");
                    break;
                
                case 2:
                    System.out.println("\nLibrary Collection:");
                    myLibrary.displayBooks();
                    break;
                
                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = myLibrary.searchBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("\nBook found: " + foundBook.title + " by " + foundBook.author + " (ISBN: " + foundBook.ISBN + ")");
                    } else {
                        System.out.println("\nBook not found.");
                    }
                    break;
                
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}