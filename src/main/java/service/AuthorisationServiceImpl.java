package service;

import model.LibrarianAccount;
import model.UserAccount;

import java.util.Date;

public class AuthorisationServiceImpl implements AuthorisationService {

    @Override
    public LibrarianAccount authoriseLibrarian(String login, String password) {
        return null;
    }

    @Override
    public UserAccount authoriseUser(String login, String password) {
        return null;
    }

    @Override
    public UserAccount signUpUser(String login, String password, String lastName, String firstName, String patronymic, Date dateOfBirth, String passportNumber, String mail) {
        return null;
    }

    @Override
    public void exit(UserAccount userAccount) {

    }
}
