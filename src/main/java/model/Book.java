package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String id;
    private String name;
    private String authorFullName;
    private String genre;
    private int yearOfPublishing;
}
