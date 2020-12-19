package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserAccount {
    private String id;
    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Date dateOfBirth;
    private String passportNumber;
    private String mail;
    Subscription subscription;
}
