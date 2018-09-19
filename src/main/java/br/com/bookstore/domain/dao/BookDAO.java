package br.com.bookstore.domain.dao;

import br.com.bookstore.domain.entity.Book;
import br.com.bookstore.util.JpaUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class BookDAO implements GenericDAO<Book> {

    @Override
    public List<Book> getAll() throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Book> books;

        try {
            books = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return books;
    }

    @Override
    public Book getById(Long id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Book book;

        try {
            book = entityManager.find(Book.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }

        return book;
    }

    @Override
    public Long save(Book book) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Long id;

        try {
            //entityManager.getTransaction().begin();
            id = (Long) entityManager.unwrap(Session.class).save(book);
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
    public void update(Book book) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            Book book = entityManager.find(Book.class, id);
            entityManager.remove(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
