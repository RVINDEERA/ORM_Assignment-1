package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Aid;
    private String name;
    private String country;
    @OneToMany(mappedBy = "author",cascade=CascadeType.ALL,orphanRemoval =true)
    private List<Book> books;
    public Author() {
    }

    public Author(int aid, String name, String country, List<Book> books) {
        Aid = aid;
        this.name = name;
        this.country = country;
        this.books = books;
    }

    public int getAid() {
        return Aid;
    }

    public void setAid(int aid) {
        Aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "Aid=" + Aid +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", books=" + books +
                '}';
    }
}
