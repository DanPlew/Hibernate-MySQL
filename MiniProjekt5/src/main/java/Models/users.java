package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class users extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String login;
    private String haslo;
    private String email;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval= true)
    private List<books> borrowedBooks = new ArrayList<>();

    public users() {
    }

    public users(String name, String surname, String birthday, int age, String login, String haslo, String email){
        super(name, surname, birthday, age);
        this.login = login;
        this.haslo = haslo;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<books> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<books> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
