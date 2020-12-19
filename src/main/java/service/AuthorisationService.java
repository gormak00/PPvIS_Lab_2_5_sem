package service;

import model.LibrarianAccount;
import model.UserAccount;

import java.util.Date;

public interface AuthorisationService {
    public LibrarianAccount authoriseLibrarian(String login, String password);

    public UserAccount authoriseUser(String login, String password);

    public UserAccount signUpUser(String login, String password, String lastName, String firstName, String patronymic, Date dateOfBirth, String passportNumber, String mail);

    public void exit(UserAccount userAccount);
}
