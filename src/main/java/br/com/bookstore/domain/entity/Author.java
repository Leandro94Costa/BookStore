package br.com.bookstore.domain.entity;

import java.util.List;

public class Author {

    private Integer id;

    private String name;

    private String firstName;

    private List<Book> books;

    public Author() {
    }

    public Author(Integer id, String name, String firstName, List<Book> books) {
        this.id = id;
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
