package view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.LibrarianAccount;
import model.UserAccount;
import service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UIMenu {
    private JFrame mainFrame;
    private JSplitPane splitPaneH;
    private JPanel backgroundPanel;

    AuthorisationServiceImpl authorisationService;
    BookServiceImpl bookService;
    ControlAccountsServiceImpl controlAccountsService;
    ControlBookServiceImpl controlBookService;
    ControlFavoriteServiceImpl controlFavoriteService;
    ControlSubscriptionServiceImpl controlSubscriptionService;
    BookmarkServiceImpl bookmarkService;

    public void showUIMenu() {
        showWelcomePage();
    }

    public void showWelcomePage() {
        mainFrame = new JFrame();
        mainFrame.setSize(800, 450);
        JPanel jpanel = new JPanel();
        mainFrame.setTitle("Вход в публичную библиотеку");
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JButton loginButton = new JButton();
        loginButton.setMaximumSize(new Dimension(400, 50));
        loginButton.setText("Войти");
        loginButton.addActionListener(actionEvent ->
        {
            mainFrame.dispose();
            showLoginMenu();
        });
        JButton signUpButton = new JButton();
        signUpButton.setMaximumSize(new Dimension(400, 50));
        signUpButton.setText("Зарегистрироваться");
        signUpButton.addActionListener(actionEvent ->
        {
            mainFrame.dispose();
            showSignUpMenu();
        });
        jpanel.add(loginButton);
        jpanel.add(signUpButton);
        mainFrame.add(jpanel);
        mainFrame.setVisible(true);
    }

    public void showLoginMenu() {
        mainFrame = new JFrame();
        mainFrame.setSize(800, 450);
        JPanel jpanel = new JPanel();
        mainFrame.setTitle("Авторизация");
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel jlabel = new JLabel();
        jlabel.setText("Логин");
        JTextField jTextField = new JTextField();
        jTextField.setMaximumSize(new Dimension(400, 50));
        JLabel jlabelPassword = new JLabel();
        jlabelPassword.setText("Пароль");
        JTextField jTextField1 = new JTextField();
        jTextField1.setMaximumSize(new Dimension(400, 50));
        JButton jButton = new JButton();
        jButton.setMaximumSize(new Dimension(400, 50));
        jButton.setText("Войти");
        jButton.addActionListener(actionEvent ->
        {
            mainFrame.dispose();
            showLibrarianMenu();
        });
        jpanel.add(jlabel);
        jpanel.add(jTextField);
        jpanel.add(jlabelPassword);
        jpanel.add(jTextField1);
        jpanel.add(jButton);
        mainFrame.add(jpanel);
        mainFrame.setVisible(true);
    }

    public void login(UserAccount userAccount){};
    public void login(LibrarianAccount librarianAccount){};

    public void showSignUpMenu() {
        mainFrame = new JFrame();
        mainFrame.setSize(800, 450);
        mainFrame.remove(mainFrame.getContentPane());
        JPanel jpanel = new JPanel();
        mainFrame.setTitle("Регистрация");
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel fullNameLabel = new JLabel();
        fullNameLabel.setText("ФИО");
        JTextField fullNameTextField = new JTextField();
        fullNameTextField.setMaximumSize(new Dimension(400, 50));
        JLabel dateLabel = new JLabel();
        dateLabel.setText("Дата рождения");
        JTextField dateTextField = new JTextField();
        dateTextField.setMaximumSize(new Dimension(400, 50));
        JLabel passportLabel = new JLabel();
        passportLabel.setText("Номер паспорта");
        JTextField passportTextField = new JTextField();
        passportTextField.setMaximumSize(new Dimension(400, 50));
        JLabel mailLabel = new JLabel();
        mailLabel.setText("Почта");
        JTextField mailTextField = new JTextField();
        mailTextField.setMaximumSize(new Dimension(400, 50));
        JLabel loginLabel = new JLabel();
        loginLabel.setText("Логин");
        JTextField loginTextField = new JTextField();
        loginTextField.setMaximumSize(new Dimension(400, 50));
        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Пароль");
        JTextField passwordTextField = new JTextField();
        passwordTextField.setMaximumSize(new Dimension(400, 50));
        JButton jButton = new JButton();
        jButton.setMaximumSize(new Dimension(400, 50));
        jButton.setText("Зарегистрироваться");
        jButton.addActionListener(actionEvent ->
        {
            mainFrame.dispose();
            showUserMenu();
        });
        jpanel.add(fullNameLabel);
        jpanel.add(fullNameTextField);
        jpanel.add(dateLabel);
        jpanel.add(dateTextField);
        jpanel.add(passportLabel);
        jpanel.add(passportTextField);
        jpanel.add(mailLabel);
        jpanel.add(mailTextField);
        jpanel.add(loginLabel);
        jpanel.add(loginTextField);
        jpanel.add(passwordLabel);
        jpanel.add(passwordTextField);
        jpanel.add(jButton);
        mainFrame.add(jpanel);
        mainFrame.setVisible(true);
    }

    public void signUp(UserAccount userAccount){};

    public void showLibrarianMenu() {
        mainFrame = new JFrame();
        mainFrame.setSize(800, 450);
        mainFrame.remove(mainFrame.getContentPane());
        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        splitPaneH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel jpanel = new JPanel();
        mainFrame.setTitle("Окно библиотекаря");
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        ButtonGroup group = new ButtonGroup();
        addRadioButton("Добавить книгу в базу", false, group, jpanel, splitPaneH, this::showAddBookMenu);
        addRadioButton("Удалить книгу из базы", false, group, jpanel, splitPaneH, this::showDeleteBookMenu);
        addRadioButton("Список всех аккаунтов посетителей", false, group, jpanel, splitPaneH, this::showAllUserAccountsMenu);
        addRadioButton("Удалить аккаунт посетителя", false, group, jpanel, splitPaneH, this::showDeleteUserAccountByLibrarianMenu);
        backgroundPanel.add(splitPaneH, BorderLayout.CENTER);
        splitPaneH.setLeftComponent(jpanel);
        mainFrame.add(backgroundPanel);
        mainFrame.setVisible(true);
    }

    public void addRadioButton(String name, boolean selected, ButtonGroup group, JPanel jpanel, JSplitPane splitPaneH, Consumer<JSplitPane> function) {
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        jpanel.add(button);
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                function.accept(splitPaneH);
            }
        };
        button.addActionListener(listener);
    }

    public void showAddBookMenu(JSplitPane splitPaneH) {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel fullNameLabel = new JLabel();
        fullNameLabel.setText("ФИО автора");
        JTextField fullNameTextField = new JTextField();
        fullNameTextField.setMaximumSize(new Dimension(400, 50));
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Название");
        JTextField nameTextField = new JTextField();
        nameTextField.setMaximumSize(new Dimension(400, 50));
        JLabel genreLabel = new JLabel();
        genreLabel.setText("Жанр");
        String[] allGenres = {
                "Детективы", "Любовные романы", "Поэзия", "Приключения", "Проза", "Триллеры", "Ужасы", "Фантастика", "Фэнтези"
        };
        JComboBox comboBox = new JComboBox(allGenres);
        JLabel yearLabel = new JLabel();
        yearLabel.setText("Год издания");
        JTextField yearTextField = new JTextField();
        yearTextField.setMaximumSize(new Dimension(400, 50));
        JButton bookDataButton = new JButton();
        bookDataButton.setMaximumSize(new Dimension(400, 50));
        bookDataButton.setText("Выбрать файл на компьютере");
        bookDataButton.addActionListener(actionEvent -> {});
        JButton addBookButton = new JButton();
        addBookButton.setMaximumSize(new Dimension(400, 50));
        addBookButton.setText("Добавить");
        addBookButton.addActionListener(actionEvent ->
        {
            mainFrame.dispose();
            showLibrarianMenu();
        });
        jpanel.add(fullNameLabel);
        jpanel.add(fullNameTextField);
        jpanel.add(nameLabel);
        jpanel.add(nameTextField);
        jpanel.add(genreLabel);
        jpanel.add(comboBox);
        jpanel.add(yearLabel);
        jpanel.add(yearTextField);
        jpanel.add(bookDataButton);
        jpanel.add(addBookButton);
        splitPaneH.setRightComponent(jpanel);
    }

    public void showDeleteBookMenu(JSplitPane splitPaneH) {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel fullNameLabel = new JLabel();
        fullNameLabel.setText("ФИО автора");
        JTextField fullNameTextField = new JTextField();
        fullNameTextField.setMaximumSize(new Dimension(400, 50));
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Название");
        JTextField nameTextField = new JTextField();
        nameTextField.setMaximumSize(new Dimension(400, 50));
        JLabel genreLabel = new JLabel();
        genreLabel.setText("Жанр");
        String[] allGenres = {
                "Детективы", "Любовные романы", "Поэзия", "Приключения", "Проза", "Триллеры", "Ужасы", "Фантастика", "Фэнтези"
        };
        JComboBox comboBox = new JComboBox(allGenres);
        JLabel yearLabel = new JLabel();
        yearLabel.setText("Год издания");
        JTextField yearTextField = new JTextField();
        yearTextField.setMaximumSize(new Dimension(400, 50));
        JButton addBookButton = new JButton();
        addBookButton.setMaximumSize(new Dimension(400, 50));
        addBookButton.setText("Удалить");
        addBookButton.addActionListener(actionEvent ->
        {
            mainFrame.dispose();
            showLibrarianMenu();
        });
        jpanel.add(fullNameLabel);
        jpanel.add(fullNameTextField);
        jpanel.add(nameLabel);
        jpanel.add(nameTextField);
        jpanel.add(genreLabel);
        jpanel.add(comboBox);
        jpanel.add(yearLabel);
        jpanel.add(yearTextField);
        jpanel.add(addBookButton);
        splitPaneH.setRightComponent(jpanel);
    }

    public void showAllUserAccountsMenu(JSplitPane splitPaneH) {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel tableLabel = new JLabel();
        tableLabel.setText("Таблица со всеми пользователями и их статусом оплаты: ");
        jpanel.add(tableLabel);
        splitPaneH.setRightComponent(jpanel);
    }

    public void showDeleteUserAccountByLibrarianMenu(JSplitPane splitPaneH) {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel tableLabel = new JLabel();
        tableLabel.setText("Таблица со всеми пользователями: ");
        jpanel.add(tableLabel);
        splitPaneH.setRightComponent(jpanel);
    }

    public void showUserMenu() {
        mainFrame = new JFrame();
        mainFrame.setSize(800, 450);
        mainFrame.remove(mainFrame.getContentPane());
        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        splitPaneH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel jpanel = new JPanel();
        mainFrame.setTitle("Окно пользователя");
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        ButtonGroup group = new ButtonGroup();
        addRadioButton("Личные данные", false, group, jpanel, splitPaneH, this::showUserDataMenu);
        addRadioButton("Читать книгу/продолжить чтение", false, group, jpanel, splitPaneH, this::showReadBookMenu);
        addRadioButton("Избранное", false, group, jpanel, splitPaneH, this::showUserFavoriteMenu);
        addRadioButton("Удалить аккаунт", false, group, jpanel, splitPaneH, this::showDeleteUserAccountMenu);
        backgroundPanel.add(splitPaneH, BorderLayout.CENTER);
        splitPaneH.setLeftComponent(jpanel);
        mainFrame.add(backgroundPanel);
        mainFrame.setVisible(true);
    }

    public void showUserDataMenu(JSplitPane splitPaneH) {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel lastNameLabel = new JLabel();
        lastNameLabel.setText("Фамилия: ");
        JLabel firstNameLabel = new JLabel();
        firstNameLabel.setText("Имя: ");
        JLabel patronymicLabel = new JLabel();
        patronymicLabel.setText("Отчество: ");
        JLabel dateOfBirthLabel = new JLabel();
        dateOfBirthLabel.setText("Дата рождения: ");
        JLabel passportNumberLabel = new JLabel();
        passportNumberLabel.setText("Номер паспорта: ");
        JLabel mailLabel = new JLabel();
        mailLabel.setText("Почта: ");
        jpanel.add(lastNameLabel);
        jpanel.add(firstNameLabel);
        jpanel.add(patronymicLabel);
        jpanel.add(dateOfBirthLabel);
        jpanel.add(passportNumberLabel);
        jpanel.add(mailLabel);
        splitPaneH.setRightComponent(jpanel);
    }

    public void showReadBookMenu(JSplitPane splitPaneH) {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel fullNameLabel = new JLabel();
        fullNameLabel.setText("ФИО автора");
        JTextField fullNameTextField = new JTextField();
        fullNameTextField.setMaximumSize(new Dimension(400, 50));
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Название");
        JTextField nameTextField = new JTextField();
        nameTextField.setMaximumSize(new Dimension(400, 50));
        JLabel genreLabel = new JLabel();
        genreLabel.setText("Жанр");
        String[] allGenres = {
                "Детективы", "Любовные романы", "Поэзия", "Приключения", "Проза", "Триллеры", "Ужасы", "Фантастика", "Фэнтези"
        };
        JComboBox comboBox = new JComboBox(allGenres);
        JButton addBookButton = new JButton();
        addBookButton.setMaximumSize(new Dimension(400, 50));
        addBookButton.setText("Читать");
        addBookButton.addActionListener(actionEvent ->
        {
            mainFrame.dispose();
            showLibrarianMenu();
        });
        jpanel.add(fullNameLabel);
        jpanel.add(fullNameTextField);
        jpanel.add(nameLabel);
        jpanel.add(nameTextField);
        jpanel.add(genreLabel);
        jpanel.add(comboBox);
        jpanel.add(addBookButton);
        splitPaneH.setRightComponent(jpanel);
    }

    public void showUserFavoriteMenu(JSplitPane splitPaneH) {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel tableLabel = new JLabel();
        tableLabel.setText("Таблица с избранными книгами пользователя: ");
        jpanel.add(tableLabel);
        splitPaneH.setRightComponent(jpanel);
    }

    public void showDeleteUserAccountMenu(JSplitPane splitPaneH) {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        JLabel jlabel = new JLabel();
        jlabel.setText("Логин");
        JTextField jTextField = new JTextField();
        jTextField.setMaximumSize(new Dimension(400, 50));
        JLabel jlabelPassword = new JLabel();
        jlabelPassword.setText("Пароль");
        JTextField jTextField1 = new JTextField();
        jTextField1.setMaximumSize(new Dimension(400, 50));
        JButton jButton = new JButton();
        jButton.setMaximumSize(new Dimension(400, 50));
        jButton.setText("Удалить");
        jButton.addActionListener(actionEvent -> {});
        jpanel.add(jlabel);
        jpanel.add(jTextField);
        jpanel.add(jlabelPassword);
        jpanel.add(jTextField1);
        jpanel.add(jButton);
        mainFrame.add(jpanel);
        mainFrame.setVisible(true);
        splitPaneH.setRightComponent(jpanel);
    }
}
