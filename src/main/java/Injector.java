import model.Book;
import model.LibrarianAccount;
import model.Subscription;
import model.UserAccount;
import service.*;
import view.UIMenu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Injector {
    private final UIMenu uiMenu;

    public Injector() {
        AuthorisationServiceImpl authorisationService = new AuthorisationServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        ControlAccountsServiceImpl controlAccountsService = new ControlAccountsServiceImpl();
        ControlBookServiceImpl controlBookService = new ControlBookServiceImpl();
        ControlFavoriteServiceImpl controlFavoriteService = new ControlFavoriteServiceImpl();
        BookmarkServiceImpl bookmarkService = new BookmarkServiceImpl();
        ControlSubscriptionServiceImpl controlSubscriptionService = new ControlSubscriptionServiceImpl();
        LibrarianAccount librarianAccount = new LibrarianAccount("librarianLogin", "librarianPass");
        UserAccount userAccount = new UserAccount("1", "userLogin", "userPass", "userLastName", "userFirstName", "userPatronymic", new Date(), "MP1111111", "mail@gmail.com", new Subscription(30, true));
        UserAccount userAccount2 = new UserAccount("2", "userLogin2", "userPass2", "userLastName2", "userFirstName2", "userPatronymic2", new Date(), "MP2222222", "mail2@gmail.com", new Subscription(0, false));
        List<UserAccount> allUserAccounts = new ArrayList<>();
        allUserAccounts.add(userAccount);
        allUserAccounts.add(userAccount2);
        controlAccountsService.setAllUserAccounts(allUserAccounts);
        Book book1 = new Book("1", "5-я волна", "Рик Янси", "Фантастика", 2013);
        Book book2 = new Book("2", "Бесконечное море", "Рик Янси", "Фантастика", 2014);
        Book book3 = new Book("3", "Последняя звезда", "Рик Янси", "Фантастика", 2016);
        List<Book> allBooks = new ArrayList<>();
        allBooks.add(book1);
        allBooks.add(book2);
        allBooks.add(book3);
        bookService.setAllBooks(allBooks);
        uiMenu = new UIMenu();
        uiMenu.setAuthorisationService(authorisationService);
        uiMenu.setBookService(bookService);
        uiMenu.setControlAccountsService(controlAccountsService);
        uiMenu.setControlBookService(controlBookService);
        uiMenu.setControlFavoriteService(controlFavoriteService);
        uiMenu.setBookmarkService(bookmarkService);
        uiMenu.setControlSubscriptionService(controlSubscriptionService);
        uiMenu.showUIMenu();
    }
}
