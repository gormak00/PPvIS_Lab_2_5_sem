package service;

import model.Book;
import model.UserAccount;

import java.util.List;

public interface ControlFavoriteService {
    public void addBookToFavorite(UserAccount userAccount, String name, String authorFullName, String genre, int yearOfPublishing);

    public void deleteBookFromFavorite(UserAccount userAccount, Book book);

    public void readBookFromFavorite(UserAccount userAccount, Book book);

    public List<Book> getAllBooksFromFavorite(UserAccount userAccount, Book book);
}
