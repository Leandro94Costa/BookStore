package br.com.bookstore.service;

import br.com.bookstore.domain.dao.AuthorDAO;
import br.com.bookstore.domain.entity.Author;

import java.util.List;

public class AuthorService {

    AuthorDAO dao = new AuthorDAO();

    public String[][] getAll(List<Integer> authorIds) throws Exception {
        int numColumns = 4;
        String[][] authors;
        List<Author> authorList = dao.getAll();
        authors = new String[authorList.size()][numColumns];
        for (int i = 0; i < authorList.size(); i++) {
            Author author = authorList.get(i);
            authorIds.add(author.getId());
            authors[i][0] = author.getFirstName();
            authors[i][1] = author.getName();
            authors[i][2] = "Editar";
            authors[i][3] = "Remover";
        }
        return authors;
    }

    public Author getById(Integer id) throws Exception {
        return dao.getById(id);
    }

    public void save(Author author) throws Exception {
        dao.save(author);
    }

    public void update(Author author) throws Exception {
        dao.update(author);
    }

    public void delete(Integer id) throws Exception {
        dao.delete(id);
    }

    public List<Author> getAuthorsByBook(Long id) throws Exception {
        return dao.getAuthorsByBook(id);
    }
}
