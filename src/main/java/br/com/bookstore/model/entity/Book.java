package br.com.bookstore.model.entity;

import javax.persistence.*;
import java.security.acl.LastOwnerException;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(length = 13)
    private String isbn;

    @Column(length = 60, nullable = false)
    private String title;

    @Column(length = 10, precision = 2, nullable = false)
    private Float price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    public Book() {
    }

    public Book(String isbn, String title, Float price, Publisher publisher, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Float getPrice() {
        return price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!isbn.equals(book.isbn)) return false;
        if (!title.equals(book.title)) return false;
        if (!price.equals(book.price)) return false;
        if (!publisher.equals(book.publisher)) return false;
        return authors.equals(book.authors);
    }

    @Override
    public int hashCode() {
        int result = isbn.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + authors.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }
}
