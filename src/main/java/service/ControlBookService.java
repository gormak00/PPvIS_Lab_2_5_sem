package service;

public interface ControlBookService {
    public void addBookToRepository(String name, String authorFullName, String genre, int yearOfPublishing);

    public void deleteBookFromRepository(String name, String authorFullName, String genre, int yearOfPublishing);
}
