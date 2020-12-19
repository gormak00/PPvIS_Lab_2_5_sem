package service;

import model.Book;
import model.UserAccount;

public interface BookService {
    public Book findBookByAuthorAndName(String author, String Name);

    public Book findBookByGenre(String Name);

    public Book readBook(Book book);

    public Book readBookWithBookmark(Book book, UserAccount userAccount);
}
