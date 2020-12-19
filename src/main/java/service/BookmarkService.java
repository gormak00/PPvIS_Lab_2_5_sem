package service;

import model.Book;
import model.UserAccount;

public interface BookmarkService {
    public void rememberCurrentPage(UserAccount userAccount, Book book, int page);
}
