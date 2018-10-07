package br.com.bookstore.service;

import br.com.bookstore.domain.dao.PublisherDAO;
import br.com.bookstore.domain.entity.Publisher;

import java.util.List;

public class PublisherService {

    PublisherDAO dao = new PublisherDAO();

    public List<Publisher> getAll() throws Exception {
        return dao.getAll();
    }

    public Publisher getById(Long id) throws Exception {
        return dao.getById(id);
    }

    public void save(Publisher publisher) throws Exception {
        dao.save(publisher);
    }

    public void update(Publisher publisher) throws Exception {
        dao.update(publisher);
    }

    public void delete(Long id) throws Exception {
        dao.delete(id);
    }
}
