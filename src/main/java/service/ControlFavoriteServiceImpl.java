package service;

import model.Book;
import model.UserAccount;

import java.util.List;

public class ControlFavoriteServiceImpl implements ControlFavoriteService {
    @Override
    public void addBookToFavorite(UserAccount userAccount, String name, String authorFullName, String genre, int yearOfPublishing) {

    }

    @Override
    public void deleteBookFromFavorite(UserAccount userAccount, Book book) {

    }

    @Override
    public void readBookFromFavorite(UserAccount userAccount, Book book) {

    }

    @Override
    public List<Book> getAllBooksFromFavorite(UserAccount userAccount, Book book) {

        return null;
    }
}
