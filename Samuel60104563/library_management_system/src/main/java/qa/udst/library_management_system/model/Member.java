package qa.udst.library_management_system.model;

import lombok.Data;
import java.util.*;

@Data
public class Member {
    private Long id;
    private String name;
    private int age;
    private String membershipType;
    private List<Book> borrowedBooks;


    public static List<Member> getAllMembers() {
        return new ArrayList<>();
    }
}