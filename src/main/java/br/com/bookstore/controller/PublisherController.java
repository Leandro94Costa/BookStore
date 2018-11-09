package br.com.bookstore.controller;

import br.com.bookstore.model.dao.PublisherDAO;
import br.com.bookstore.model.entity.Publisher;

import java.util.List;
import java.util.Map;

public class PublisherController {

    private PublisherDAO dao = new PublisherDAO();

    public String[][] getAll(List<Integer> publisherIds) throws Exception {
        return fillPublisher(dao.getAll(), publisherIds);
    }

    private String[][] fillPublisher(List<Publisher> publisherList, List<Integer> publisherIds) throws Exception {
        int numColumns = 4;
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

    public boolean hasBooks(Integer id) {
        return dao.hasBooks(id);
    }

    public String[][] search(String name, List<Integer> publisherIds) throws Exception {
        return fillPublisher(dao.findByName(name), publisherIds);
    }

    public String validate(Publisher publisher) {
        String validation = null;

        if ("".equals(publisher.getName())) {
            validation = "Campo NOME obrigatório";
        } else if (publisher.getName().length() > 30) {
            validation = "Campo NOME deve conter até 30 caracteres";
        }

        if (publisher.getUrl() != null && publisher.getUrl().length() > 80) {
            validation = "Campo URL deve conter até 80 caracteres";
        }
        return validation;
    }
}
