package qa.udst.library_management_system.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qa.udst.library_management_system.model.Book;
import qa.udst.library_management_system.services.BorrowingService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BorrowingController {
    private final BorrowingService borrowingService = new BorrowingService();

    @GetMapping("/borrowings/{memberId}")
    public List<Book> getBorrowedBooks(@PathVariable Long memberId) {
        return borrowingService.getBorrowedBooks(memberId);
    }

    @GetMapping("/borrowings/{memberId}/overdue")
    public List<Book> getOverdueBooks(@PathVariable Long memberId) {
        return borrowingService.getOverdueBooks(memberId);
    }
}
