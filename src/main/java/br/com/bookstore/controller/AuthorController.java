package br.com.bookstore.controller;

import br.com.bookstore.model.dao.AuthorDAO;
import br.com.bookstore.model.entity.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuthorController {

    AuthorDAO dao = new AuthorDAO();

    public String[][] getAll(List<Integer> authorIds) throws Exception {
        return fillAuthor(dao.getAll(), authorIds);
    }

    private String[][] fillAuthor(List<Author> authorList, List<Integer> authorIds) throws Exception {
        int numColumns = 4;
        String[][] authors = new String[authorList.size()][numColumns];
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

    public String[] getNames(Map<Integer, Integer> authorIds) throws Exception {
        List<Author> authors = dao.getAll();
        String[] names = new String[authors.size()];
        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            authorIds.put(i, author.getId());
            names[i] = author.getFirstName() + " " + author.getName();
        }
        return names;
    }

    public List<Author> getAuthorsById(List<Integer> authorIds) throws Exception {
        List<Author> authors = new ArrayList<>();
        for (Integer id : authorIds) {
            authors.add(getById(id));
        }
        return authors;
    }

    public Author getById(Integer id) throws Exception {
        return dao.getById(id);
    }

    public void save(Author author) throws Exception {
        if (author.getId() == null) {
            dao.save(author);
        } else {
            dao.update(author);
        }
    }

    public void delete(Integer id) throws Exception {
        dao.delete(id);
    }

    public List<Author> getAuthorsByBook(String id) throws Exception {
        return dao.getAuthorsByBook(id);
    }

    public boolean hasBooks(Integer id) {
        return dao.hasBooks(id);
    }

    public String validate(Author author) {
        String validation = null;
        if ("".equals(author.getFirstName())) {
            validation = "Campo NOME obrigatório";
        } else if (author.getFirstName().length() > 25) {
            validation = "Campo NOME deve conter até 25 caracteres";
        }
        if ("".equals(author.getName())) {
            validation = "Campo SOBRENOME obrigatório";
        } else if (author.getName().length() > 25) {
            validation = "Campo SOBRENOME deve conter até 25 caracteres";
        }
        return validation;
    }

    public String[][] search(String name, List<Integer> authorIds) throws Exception {
        return fillAuthor(dao.findByName(name), authorIds);
    }
}
