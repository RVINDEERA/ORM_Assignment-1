package lk.ijse.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Bid;
    private String title;
    private LocalDate publicationYear;
    private double price;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }


    public Book(int bid, String title, LocalDate publicationYear, double price) {
        Bid = bid;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public int getBid() {
        return Bid;
    }

    public void setBid(int bid) {
        Bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Bid=" + Bid +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                '}';
    }
}
