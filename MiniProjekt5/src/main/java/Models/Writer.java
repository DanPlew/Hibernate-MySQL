package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Writer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String deathday;

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval= true)
    private List<books> listOfWrittenBooks = new ArrayList<>();

    public Writer() {
    }

    public Writer(String name, String surname, String birthday, int age, String deathday){
        super(name, surname, birthday, age);
        this.deathday = deathday;
    }

    public Writer(String name, String surname, String birthday, int age){
        super(name, surname, birthday, age);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }

    public List<books> getListOfWrittenBooks() {
        return listOfWrittenBooks;
    }

    public void setListOfWrittenBooks(List<books> listOfWrittenBooks) {
        this.listOfWrittenBooks = listOfWrittenBooks;
    }
}
