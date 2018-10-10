package br.com.bookstore.service;

import br.com.bookstore.domain.dao.PublisherDAO;
import br.com.bookstore.domain.entity.Publisher;

import java.util.List;
import java.util.Map;

public class PublisherService {

    PublisherDAO dao = new PublisherDAO();

    public String[][] getAll(List<Integer> publisherIds) throws Exception {
        int numColumns = 4;
        List<Publisher> publisherList = dao.getAll();
        String[][] publishers = new String[publisherList.size()][numColumns];
        for (int i = 0; i < publisherList.size(); i++) {
            Publisher publisher = publisherList.get(i);
            publisherIds.add(publisher.getId());
            publishers[i][0] = publisher.getName();
            publishers[i][1] = publisher.getUrl();
            publishers[i][2] = "Editar";
            publishers[i][3] = "Remover";
        }
        return publishers;
    }

    public String[] getNames(Map<Integer, Integer> publisherIds) throws Exception {
        List<Publisher> publishers = dao.getAll();
        String[] names = new String[publishers.size()];
        for (int i = 0; i < publishers.size(); i++) {
            Publisher publisher = publishers.get(i);
            publisherIds.put(i, publisher.getId());
            names[i] = publisher.getName();
        }
        return names;
    }

    public Publisher getById(Integer id) throws Exception {
        return dao.getById(id);
    }

    public void save(Publisher publisher) throws Exception {
        if (publisher.getId() == null) {
            dao.save(publisher);
        } else {
            dao.update(publisher);
        }
    }

    public void delete(Integer id) throws Exception {
        dao.delete(id);
    }
}
