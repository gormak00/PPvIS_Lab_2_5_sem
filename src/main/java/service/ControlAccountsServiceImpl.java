package service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.UserAccount;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ControlAccountsServiceImpl implements ControlAccountsService {
    private List<UserAccount> allUserAccounts = new ArrayList<>();

    @Override
    public void deleteUserAccount(UserAccount userAccount) {

    }

    @Override
    public List<UserAccount> getAllAccounts() {
        return null;
    }

    @Override
    public void deleteAccount(String login, String password) {

    }
}
