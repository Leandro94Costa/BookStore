package br.com.bookstore.service;

import br.com.bookstore.domain.dao.AuthorDAO;
import br.com.bookstore.domain.entity.Author;

import java.util.List;

public class AuthorService {

    AuthorDAO dao = new AuthorDAO();

    public List<Author> getAll() throws Exception {
        return dao.getAll();
    }

    public Author getById(Long id) throws Exception {
        return dao.getById(id);
    }

    public void save(Author author) throws Exception {
        dao.save(author);
    }

    public void update(Author author) throws Exception {
        dao.update(author);
    }

    public void delete(Long id) throws Exception {
        dao.delete(id);
    }

    public List<Author> getAuthorsByBook(Long id) throws Exception {
        return dao.getAuthorsByBook(id);
    }
}
