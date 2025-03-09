package qa.udst.library_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qa.udst.library_management_system.model.Book;
import qa.udst.library_management_system.model.Journal;
import qa.udst.library_management_system.model.Magazine;
import qa.udst.library_management_system.model.Member;
import java.util.List;
import java.util.ArrayList;

@Component
public class LibraryRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Journal journal = new Journal();
        journal.setTitle("Book of Journals");
        journal.setAuthor("Journal Master");
        journal.setIssueNumber("12345");
        journal.setPublisher("Journal Pub Co.");

        Magazine magazine = new Magazine();
        magazine.setTitle("Monthly Reads");
        magazine.setAuthor("Magazine Maven");
        magazine.setMonthlyEdition("May 2023");


        Member member = new Member();
        member.setName("John Doe");
        member.setAge(25);
        member.setMembershipType("Premium");


        List<Book> borrowedBooks = new ArrayList<>();
        borrowedBooks.add(journal);
        borrowedBooks.add(magazine);
        member.setBorrowedBooks(borrowedBooks);

        System.out.println("Member: " + member);
        System.out.println("Journal: " + journal);
        System.out.println("Magazine: " + magazine);
    }
}