package br.com.bookstore.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "fname")
    private String firstName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
    }

    public Author(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    public Author(String name, String firstName, List<Book> books) {
        this.name = name;
        this.firstName = firstName;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (!id.equals(author.id)) return false;
        if (!name.equals(author.name)) return false;
        if (!firstName.equals(author.firstName)) return false;
        return books != null ? books.equals(author.books) : author.books == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", books=" + books +
                '}';
    }
}
