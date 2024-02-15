package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        Book book1 = new Book();
        book1.setTitle("Apegama");
        book1.setPublicationYear(LocalDate.of(1964,5,24));
        book1.setPrice(500);

        Book book2 =new Book();
        book2.setTitle("Elon");
        book2.setPublicationYear(LocalDate.of(2019,7,3));
        book2.setPrice(5000);

        Book book3 = new Book();
        book3.setTitle("HarryPOtter");
        book3.setPublicationYear(LocalDate.of(2000,1,5));

        Book book4 = new Book();
        book3.setTitle("Hathpana");
        book3.setPublicationYear(LocalDate.of(1970,6,24));


        ArrayList<Book>bookArrayList=new ArrayList<>();
        bookArrayList.add(book1);
        bookArrayList.add(book2);
        bookArrayList.add(book3);
        bookArrayList.add(book4);

        Author author1 = new Author();
        author1.setName("Martin Wickramsinghe");
        author1.setCountry("Sri lanka");
        author1.setBooks(bookArrayList);


        Author author2 = new Author();
        author2.setName("Ashlee Vance");
        author2.setCountry("America");
        author1.setBooks(bookArrayList);

        Author author3 = new Author();
        author3.setName("J.K.Rowling");
        author3.setCountry("England");
        author1.setBooks(bookArrayList);

        Author author4 = new Author();
        author4.setName("Kumarathunga Munidasa");
        author4.setCountry("Sri lanka");
        author4.setBooks(bookArrayList);

        /*session.save(author1);
        session.save(book1);
        session.save(author2);
        session.save(book2);
        session.save(author3);
        session.save(book3);
        session.save(author4);
        session.save(book4);*/

        /*1. Write an HQL query to retrieve all books published after the year 2010*/
        Query query =session.createQuery("from Book where year(publicationYear)= :year");

        query.setParameter("year",2010);
        List<Book>bookList=query.list();
        for (Book book  : bookList){
            System.out.println("Book Id :"+ book.getBid());
            System.out.println("Price :"+ book.getPrice());
            System.out.println("Publication Year :"+ book.getPublicationYear());
            System.out.println("Name :"+book.getTitle()+ "\n");
        }
        /*2. Write an HQL update query to increase the price of all books published by a specific author by 10%.*/

        /*Query query = session.createQuery("update Book set price = price * 1.1 where author.id IN (:authorIds)");
        query.setParameter("authorID", 3);
        int result = query.executeUpdate();
        System.out.println("Books price updated by 10% : " + result);*/


        /*3. Implement a method to delete an author and cascade the deletion to all associated books
        using appropriate cascade options.*/

        /*Create a query to delete books associated with a specific author*/
        /*Query deleteBooksQuery = session.createQuery("delete from Book b where b.author.id = :id");
        deleteBooksQuery.setParameter("id", 1); // Set the author ID here
        int deletedBooksCount = deleteBooksQuery.executeUpdate();
        System.out.println("Number of books deleted: " + deletedBooksCount);*/

        /*Create a query to delete the author*/
        /*Query deleteAuthorQuery = session.createQuery("delete from Author where id = :id");
        deleteAuthorQuery.setParameter("id", 1); // Set the author ID here
        int deletedAuthorCount = deleteAuthorQuery.executeUpdate();
        System.out.println("Number of authors deleted: " + deletedAuthorCount);*/


        /*4. Write an HQL query to find the average price of all books.*/

        /*Query query = session.createQuery("select avg(price) from Book");
        Double avg = (Double) query.uniqueResult();
        System.out.println("Average Price of a Book :" + avg);*/


        /*5. Write an HQL query to retrieve all authors along with the count of books they have written.*/

        /*Query query = session.createQuery("select a.name,count (b.id) from Author a " +
                "inner join a.books b group by a.id");
        List<Object []> list = query.list();

        for (Object [] objects : list) {
            String name = (String) objects[0];
            Long bookCount = (Long) objects[1];

            System.out.println("Author : " + name + "\tTotal Books : " +  bookCount);

        }*/


        /*6. Write an HQL query using named parameters to retrieve books written by authors from a
        specific country.*/

        /*Query query = session.createQuery("SELECT book FROM Book AS book WHERE book.author.country = :country");
        query.setParameter("country", "England");
        List<Book> results = query.list();

        for (Book book : results) {
            System.out.println("The books from England : " + book.getTitle());
        }*/


        transaction.commit();
        session.close();

    }
}