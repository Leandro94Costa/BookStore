package br.com.bookstore.domain.dao;

import br.com.bookstore.domain.entity.Publisher;
import br.com.bookstore.util.JpaUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class PublisherDAO implements GenericDAO<Publisher, Integer> {

    @Override
    public List<Publisher> getAll() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Publisher> publishers;

        try {
            publishers = entityManager.createQuery("select p from Publisher p", Publisher.class).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return publishers;
    }

    @Override
    public Publisher getById(Integer id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Publisher publisher;

        try {
            publisher = entityManager.find(Publisher.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return publisher;
    }

    @Override
    public Integer save(Publisher publisher) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Integer id;

        try {
            //entityManager.getTransaction().begin();
            id = (Integer) entityManager.unwrap(Session.class).save(publisher);
            //entityManager.getTransaction().commit();
        } catch (Exception e) {
            //entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return id;
    }

    @Override
    public void update(Publisher publisher) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(publisher);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            Publisher publisher = entityManager.find(Publisher.class, id);
            entityManager.remove(publisher);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
