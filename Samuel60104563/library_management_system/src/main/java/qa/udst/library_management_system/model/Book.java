package qa.udst.library_management_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Book {
    private Long id;
    private String title;
    private String author;
    private int yearPublished;
    private boolean isAvailable;
}