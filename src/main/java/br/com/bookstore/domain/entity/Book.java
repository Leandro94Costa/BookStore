package br.com.bookstore.domain.entity;

import java.util.List;

public class Book {

    private Long isbn;

    private String title;

    private Float price;

    private Publisher publisher;

    private List<Author> authors;

    public Book() {
    }

    public Book(Long isbn, String title, Float price, Publisher publisher, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
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
