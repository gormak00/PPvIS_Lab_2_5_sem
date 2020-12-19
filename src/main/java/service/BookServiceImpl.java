package service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Book;
import model.UserAccount;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class BookServiceImpl implements BookService, BookmarkService{
    private List<Book> allBooks = new ArrayList<>();
    @Override
    public Book findBookByAuthorAndName(String author, String Name) {
        return null;
    }

    @Override
    public Book findBookByGenre(String Name) {
        return null;
    }

    @Override
    public Book readBook(Book book) {
        return null;
    }

    @Override
    public Book readBookWithBookmark(Book book, UserAccount userAccount) {
        return null;
    }

    @Override
    public void rememberCurrentPage(UserAccount userAccount, Book book, int page) {

    }
}
