package qa.udst.library_management_system.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qa.udst.library_management_system.model.Book;
import qa.udst.library_management_system.services.BookService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService = new BookService();

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/books/available")
    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }
}