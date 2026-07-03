package menu;

import controller.BookController;
import model.Book;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

import java.util.List;

public class BookMenu {

    private final BookController controller;

    public BookMenu() {

        controller = new BookController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Book Management");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

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
                    ConsolePrinter.warning("Invalid Choice");

            }

        }

    }

    private void addBook() {

        Book book = new Book();

        book.setIsbn(InputUtil.readString("ISBN : "));
        book.setTitle(InputUtil.readString("Title : "));
        book.setAuthor(InputUtil.readString("Author : "));
        book.setPublisher(InputUtil.readString("Publisher : "));
        book.setCategory(InputUtil.readString("Category : "));
        book.setQuantity(InputUtil.readInt("Quantity : "));
        book.setAvailableQuantity(book.getQuantity());

        if(controller.addBook(book))

            ConsolePrinter.success("Book Added Successfully.");

        else

            ConsolePrinter.error("Failed.");

    }

    private void viewBooks(){

        List<Book> books = controller.getAllBooks();

        if (books.isEmpty()) {
            ConsolePrinter.info("No books found in library.");
            return;
        }

        TablePrinter.heading("ID", "ISBN", "Title", "Author", "Publisher", "Category", "Quantity", "Available");

        for(Book b : books){

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    b.getBookId(),
                    b.getIsbn(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getPublisher(),
                    b.getCategory(),
                    b.getQuantity(),
                    b.getAvailableQuantity());

        }

        TablePrinter.line();

    }

    private void searchBook(){

        int id = InputUtil.readInt("Book ID : ");

        Book b = controller.getBookById(id);

        if(b != null) {

            TablePrinter.heading("ID", "ISBN", "Title", "Author", "Publisher", "Category", "Quantity", "Available");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    b.getBookId(),
                    b.getIsbn(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getPublisher(),
                    b.getCategory(),
                    b.getQuantity(),
                    b.getAvailableQuantity());
            TablePrinter.line();

        } else

            ConsolePrinter.error("Book Not Found.");

    }

    private void updateBook(){

        int id = InputUtil.readInt("Book ID : ");

        Book book = controller.getBookById(id);

        if(book == null){

            ConsolePrinter.error("Book Not Found.");

            return;

        }

        book.setQuantity(InputUtil.readInt("New Quantity : "));

        book.setAvailableQuantity(book.getQuantity());

        if(controller.updateBook(book))

            ConsolePrinter.success("Updated Successfully.");

        else

            ConsolePrinter.error("Update Failed.");

    }

    private void deleteBook(){

        int id = InputUtil.readInt("Book ID : ");

        if(controller.deleteBook(id))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

}