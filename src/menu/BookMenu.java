package menu;

import controller.BookController;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class BookMenu {

    private final Scanner scanner;
    private final BookController controller;

    public BookMenu() {

        scanner = new Scanner(System.in);
        controller = new BookController();

    }

    public void start() {

        while (true) {

            System.out.println("\n===============================");
            System.out.println(" BOOK MANAGEMENT ");
            System.out.println("===============================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    updateBook();
                    break;

                case 5:
                    deleteBook();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice");

            }

        }

    }

    private void addBook() {

        Book book = new Book();

        System.out.print("ISBN : ");
        book.setIsbn(scanner.nextLine());

        System.out.print("Title : ");
        book.setTitle(scanner.nextLine());

        System.out.print("Author : ");
        book.setAuthor(scanner.nextLine());

        System.out.print("Publisher : ");
        book.setPublisher(scanner.nextLine());

        System.out.print("Category : ");
        book.setCategory(scanner.nextLine());

        System.out.print("Quantity : ");
        book.setQuantity(Integer.parseInt(scanner.nextLine()));

        book.setAvailableQuantity(book.getQuantity());

        if(controller.addBook(book))

            System.out.println("Book Added Successfully.");

        else

            System.out.println("Failed.");

    }

    private void viewBooks(){

        List<Book> books=
                controller.getAllBooks();

        for(Book book:books){

            System.out.println(book);

        }

    }

    private void searchBook(){

        System.out.print("Book ID : ");

        int id=
                Integer.parseInt(scanner.nextLine());

        Book book=
                controller.getBookById(id);

        if(book!=null)

            System.out.println(book);

        else

            System.out.println("Book Not Found.");

    }

    private void updateBook(){

        System.out.print("Book ID : ");

        int id=
                Integer.parseInt(scanner.nextLine());

        Book book=
                controller.getBookById(id);

        if(book==null){

            System.out.println("Book Not Found.");

            return;

        }

        System.out.print("New Quantity : ");

        book.setQuantity(
                Integer.parseInt(scanner.nextLine()));

        book.setAvailableQuantity(book.getQuantity());

        if(controller.updateBook(book))

            System.out.println("Updated Successfully.");

        else

            System.out.println("Update Failed.");

    }

    private void deleteBook(){

        System.out.print("Book ID : ");

        int id=
                Integer.parseInt(scanner.nextLine());

        if(controller.deleteBook(id))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

}