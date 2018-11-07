package br.com.bookstore.model.dao;

import br.com.bookstore.model.entity.Publisher;
import br.com.bookstore.util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PublisherDAO implements GenericDAO<Publisher, Integer> {

    @Override
    public List<Publisher> getAll() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Publisher> publishers;
        try {
            publishers = entityManager.createQuery("select p from Publisher p order by p.name", Publisher.class).getResultList();
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

    public boolean hasBooks(Integer id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        boolean result;
        result = (boolean) entityManager.createQuery("select case when (count(b.isbn) > 0) then true else false end from Book b where b.publisher.id = :publisherId")
                .setParameter("publisherId", id)
                .getSingleResult();
        entityManager.close();
        return result;
    }

    @Override
    public void save(Publisher publisher) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(publisher);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
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

    public List<Publisher> findByName(String name) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Publisher> publishers;
        try {
            publishers = entityManager.createQuery("select p from Publisher p where p.name like :name")
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
        return publishers;
    }
}
