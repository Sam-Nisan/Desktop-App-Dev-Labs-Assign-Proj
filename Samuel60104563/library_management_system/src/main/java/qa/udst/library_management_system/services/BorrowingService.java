package qa.udst.library_management_system.services;

import qa.udst.library_management_system.model.Book;
import qa.udst.library_management_system.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class BorrowingService {

    public List<Book> getBorrowedBooks(Long memberId) {
        Member member = findMemberById(memberId);
        if (member != null) {
            return member.getBorrowedBooks();
        }
        return new ArrayList<>();
    }

    public List<Book> getOverdueBooks(Long memberId) {
        List<Book> borrowedBooks = getBorrowedBooks(memberId);
        return borrowedBooks.stream()
                .filter(book -> book.getYearPublished() < 2023 && !book.isAvailable())
                .collect(Collectors.toList());
    }

    private Member findMemberById(Long memberId) {
        List<Member> allMembers = Member.getAllMembers();
        return allMembers.stream()
                .filter(member -> member.getId().equals(memberId))
                .findFirst()
                .orElse(null);
    }
}
