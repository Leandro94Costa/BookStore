package br.com.bookstore.service;

import br.com.bookstore.domain.dao.BookDAO;
import br.com.bookstore.domain.entity.Author;
import br.com.bookstore.domain.entity.Book;

import java.util.List;

public class BookService {

    BookDAO dao = new BookDAO();

    public String[][] getAll(List<Long> bookIds) throws Exception {
        int numColumns = 7;
        List<Book> bookList = dao.getAll();
        String[][] books = new String[bookList.size()][numColumns];
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            bookIds.add(book.getIsbn());
            books[i][0] = book.getIsbn().toString();
            books[i][1] = book.getTitle().toString();
            books[i][2] = book.getPrice().toString();
            books[i][3] = getAuthors(book);
            books[i][4] = book.getPublisher().getName().toString();
            books[i][5] = "Editar";
            books[i][6] = "Remover";
        }
        return books;
    }

    private String getAuthors(Book book) throws Exception {
        AuthorService authorService = new AuthorService();
        List<Author> authors = authorService.getAuthorsByBook(book.getIsbn());
        String authorsConcat = "";
        int count = 1;
        for (Author author : authors) {
            authorsConcat += count != authors.size() ? author.getFirstName() + " " + author.getName() + ", "
                    : author.getFirstName() + " " + author.getName();
            count++;
        }
        return authorsConcat;
    }

    public Book getById(Long id) throws Exception {
        return dao.getById(id);
    }

    public void save(Book book) throws Exception {
        if (getById(book.getIsbn()) == null) {
            dao.save(book);
        } else {
            dao.update(book);
        }
    }

    public void delete(Long id) throws Exception {
        dao.delete(id);
    }

    public void deleteByPublisher(Integer id) throws Exception {
        dao.deleteByPublisher(id);
    }
}
