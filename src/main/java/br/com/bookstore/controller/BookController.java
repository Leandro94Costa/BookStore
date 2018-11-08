package br.com.bookstore.controller;

import br.com.bookstore.model.dao.BookDAO;
import br.com.bookstore.model.entity.Author;
import br.com.bookstore.model.entity.Book;

import java.util.List;

public class BookController {

    BookDAO dao = new BookDAO();

    public String[][] getAll(List<String> bookIds) throws Exception {
        return fillBooks(dao.getAll(), bookIds);
    }

    private String[][] fillBooks(List<Book> bookList, List<String> bookIds) throws Exception {
        int numColumns = 7;
        String[][] books = new String[bookList.size()][numColumns];
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            bookIds.add(book.getIsbn());
            books[i][0] = book.getIsbn().toString();
            books[i][1] = book.getTitle();
            books[i][2] = book.getPrice().toString();
            books[i][3] = getAuthors(book);
            books[i][4] = book.getPublisher().getName();
            books[i][5] = "Editar";
            books[i][6] = "Remover";
        }
        return books;
    }

    private String getAuthors(Book book) throws Exception {
        AuthorController authorController = new AuthorController();
        List<Author> authors = authorController.getAuthorsByBook(book.getIsbn());
        String authorsConcat = "";
        int count = 1;
        for (Author author : authors) {
            authorsConcat += count != authors.size() ? author.getFirstName() + " " + author.getName() + ", "
                    : author.getFirstName() + " " + author.getName();
            count++;
        }
        return authorsConcat;
    }

    public Book getById(String id) throws Exception {
        return dao.getById(id);
    }

    public void save(Book book) throws Exception {
        if (getById(book.getIsbn()) == null) {
            dao.save(book);
        } else {
            dao.update(book);
        }
    }

    public void delete(String id) throws Exception {
        dao.delete(id);
    }

    public void deleteByPublisher(Integer id) throws Exception {
        dao.deleteByPublisher(id);
    }

    public void deleteByAuthor(Integer id) throws Exception {
        List<Long> ids = dao.getIdsByAuthor(id);
        dao.deleteByAuthor(ids);
    }

    public String[][] search(int searchIndex, String search, List<String> bookIds) throws Exception {
        switch (searchIndex) {
            case 0: return searchByISBN(search, bookIds);

            case 1: return searchByTitle(search, bookIds);

            case 2: return searchByAuthor(search, bookIds);

            case 3: return searchByPublisher(search, bookIds);

            default: return getAll(bookIds);
        }
    }

    private String[][] searchByISBN(String search, List<String> bookIds) throws Exception {
        return fillBooks(dao.findByISBN(Long.valueOf(search)), bookIds);
    }

    private String[][] searchByTitle(String search, List<String> bookIds) throws Exception {
        return fillBooks(dao.findByTitle(search), bookIds);
    }

    private String[][] searchByAuthor(String search, List<String> bookIds) throws Exception {
        return fillBooks(dao.findByAuthor(search), bookIds);
    }

    private String[][] searchByPublisher(String search, List<String> bookIds) throws Exception {
        return fillBooks(dao.findByPublisher(search), bookIds);
    }

    public String validate(Book book) {
        String validation = null;

        if ("".equals(book.getIsbn())) {
            validation = "Campo ISBN obrigatório";
        } else if (book.getIsbn().length() != 10 && book.getIsbn().length() != 13) {
            validation = "Campo ISBN deve conter 10 ou 13 dígitos";
        }

        if ("".equals(book.getTitle())) {
            validation = "Campo TÍTULO obrigatório";
        } else if (book.getTitle().length() > 60) {
            validation = "Campo TÍTULO deve ter até 60 caracteres";
        }

        if ("".equals(book.getPrice())) {
            validation = "Campo PREÇO obrigatório";
        } else if (book.getPrice() <= 0 || book.getPrice() > 9999999.99) {
            validation = "Campo PREÇO deve ser entre 0,01 e 9999999,99";
        }

        if (book.getPublisher() == null) {
            validation = "Editora obrigatória";
        }
        if (book.getAuthors() == null) {
            validation = "Autor obrigatória";
        }

        return validation;
    }
}
