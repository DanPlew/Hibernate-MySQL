package Main;

import Models.Writer;
import Models.books;
import Models.users;
import Session.BooksTranzaction;
import Session.UsersTranzaction;
import Session.WritersTranzaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] argv){
        //booksTranzaction.add(new books(UUID.randomUUID().toString(), "Naruto"));
        //booksTranzaction.delete(2L);
        //books books = booksTranzaction.find(2L);
        //System.out.println(books);
        //List<books> bookList = booksTranzaction.findAll();
        //bookList.forEach(books -> System.out.println(books));
        //booksTranzaction.cleanUp();


        //usersTranzaction.add(new users("Daniel", "Plewinski", "29-04-1997", 23, "danonek", "danonek", "danonek@gmail.com"));
        //usersTranzaction.cleanUp();

        Writer writer1 = new Writer("Robert", "Wujtowicz", "04.06.1976", 43);
        Writer writer2 = new Writer("Anna", "Malakowska", "02.12.1980", 39);

        List<books> listaKsiazek = new ArrayList<>();
        List<books> listaKsiazek2 = new ArrayList<>();
        books books1 = new books(UUID.randomUUID().toString(), "Jas mały na grochu");
        books books2 = new books(UUID.randomUUID().toString(), "Anna z Podkarpacia");
        books books3 = new books(UUID.randomUUID().toString(), "Wielkie wody plyna");

        listaKsiazek.add(books1);
        listaKsiazek.add(books2);
        listaKsiazek2.add(books3);

        writer1.setListOfWrittenBooks(listaKsiazek);
        writer2.setListOfWrittenBooks(listaKsiazek2);

        users users1 = new users("Daniel", "Plewinski", "29-04-1997", 23, "danonek", "danonek", "danonek@gmail.com");
        users users2 = new users("Tomasz", "Iksinski", "29-04-1997", 23, "tomcio", "paluch", "tomcio@gmail.com");
        users1.setBorrowedBooks(listaKsiazek);
        users2.setBorrowedBooks(listaKsiazek2);

        WritersTranzaction writersTranzaction = new WritersTranzaction();
        writersTranzaction.add(writer1);
        writersTranzaction.add(writer2);
        writersTranzaction.cleanUp();
    }
}
