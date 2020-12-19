package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Bookmark {
    private String userId;
    private String bookId;
    private int pageNumber;
}
