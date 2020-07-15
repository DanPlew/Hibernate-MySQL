package Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class books implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookSpecialId;
    private String bookName;


    public books() {
    }

    public books(String bookSpecialId, String bookName){
        this.bookSpecialId = bookSpecialId;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookSpecialId() {
        return bookSpecialId;
    }

    public void setBookSpecialId(String bookSpecialId) {
        this.bookSpecialId = bookSpecialId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    @Override
    public String toString() {
        return bookSpecialId + " " + bookName;
    }
}
