package service;

import model.UserAccount;

import java.util.List;

public interface ControlAccountsService {
    public void deleteUserAccount(UserAccount userAccount);

    public List<UserAccount> getAllAccounts();

    public void deleteAccount(String login, String password);
}
